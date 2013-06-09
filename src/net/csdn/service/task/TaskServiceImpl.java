package net.csdn.service.task;

import com.google.inject.Inject;
import net.csdn.common.collect.Tuple;
import net.csdn.common.logging.CSLogger;
import net.csdn.common.logging.Loggers;
import net.csdn.common.settings.Settings;
import net.csdn.controller.thrift.CTask;
import net.csdn.controller.thrift.DBDumpService;
import net.csdn.controller.thrift.DBException;
import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.document.TaskLog;
import net.csdn.exception.CronParseException;
import net.csdn.modules.threadpool.ThreadPoolService;
import net.csdn.modules.thrift.ThriftClient;
import net.csdn.modules.thrift.util.PojoCopy;
import net.csdn.util.cron.CronExpression;
import org.apache.thrift.TException;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import static net.csdn.common.collections.WowCollections.map;


/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class TaskServiceImpl implements TaskService {

    private CSLogger logger = Loggers.getLogger(TaskServiceImpl.class);
    private static final Map<String, Tuple<CronExpression, Task>> triggers = new ConcurrentHashMap<String, Tuple<CronExpression, Task>>();
    private static final Map<String, CSDNFutureTask<Boolean>> scheduleThreads = new ConcurrentHashMap<String, CSDNFutureTask<Boolean>>();

    private final ThriftClient<DBDumpService.Client> crawler;
    private ThreadPoolService threadPoolService;

    private final static String DumpServer = "thrift.servers.dump";
    private Settings settings;

    @Inject
    public TaskServiceImpl(Settings settings, ThreadPoolService threadPoolService) {
        this.settings = settings;
        this.crawler = ThriftClient.build(DBDumpService.Client.class);
        this.threadPoolService = threadPoolService;
        initialize();
    }

    @Override
    public Task createTask(Task task) {
        if (task.save()) {
            addTrigger(task);
        }
        return task;
    }

    @Override
    public boolean removeTask(String name) {
        cancelTask(name);
        triggers.remove(name);
        scheduleThreads.remove(name);
        return true;
    }

    @Override
    public List<TaskLog> queryLog(String name, int start, int size) {
        Map query = name != null ? map("taskName", name) : map();
        return TaskLog.where(query).skip(start).limit(size).fetch();
    }

    @Override
    public boolean resumeTasks() {
        for (Map.Entry<String, Tuple<CronExpression, Task>> entry : triggers.entrySet()) {
            CSDNFutureTask<Boolean> futureTask = scheduleThreads.get(entry.getKey());
            futureTask.start(threadPoolService);
        }
        return true;
    }

    @Override
    public boolean cancelTask(String name) {
        scheduleThreads.get(name).stop();
        return true;
    }

    @Override
    public boolean startTask(String name) {
        CSDNFutureTask task = scheduleThreads.get(name);
        if (task == null) return false;
        scheduleThreads.get(name).start(threadPoolService);
        return true;
    }

    private void initialize() {
        List<Task> taskList = Task.findAll();
        for (Task task : taskList) {
            addTrigger(task);
        }
    }


    private void addTrigger(final Task task) {

        if (triggers.containsKey(task.getName())) {
            cancelTask(task.getName());
        }

        try {
            triggers.put(task.getName(), new Tuple<CronExpression, Task>(new CronExpression(task.getCronTime()), task));
        } catch (ParseException e) {
            logger.error("task [" + task.getName() + "] cron expression [" + task.getCronTime() + "] error");
            TaskLog.createLog(task, map(
                    "message", "task [" + task.getName() + "] cron expression [" + task.getCronTime() + "] error"
            ));
            throw new CronParseException(e.getMessage());

        }


        scheduleThreads.put(task.getName(), new CSDNFutureTask<Boolean>(task, new Callable() {
            @Override
            public Object call() throws Exception {
                CronExpression cronExpression = triggers.get(task.getName()).v1();
                Date nextValidTime = cronExpression.getNextValidTimeAfter(new Date());
                while (nextValidTime != null) {
                    while (new DateTime(nextValidTime).isAfterNow()) {
                        Thread.currentThread().sleep(1000);
                    }

                    CSDNFutureTask futureTask = scheduleThreads.get(task.getName());
                    if (futureTask == null) break;

                    List<DB> dbs = task.dbs().find();
                    for (DB db : dbs) {
                        dumpData(db);
                    }
                    nextValidTime = cronExpression.getNextValidTimeAfter(new Date());
                }

                return true;
            }
        }));

    }

    private void dumpData(final DB db) {
        String server = settings.getAsArray(DumpServer)[0];
        crawler.execute(server, new ThriftClient.Callback<DBDumpService.Client>() {
            @Override
            public void execute(DBDumpService.Client client) {
                try {
                    client.dump(PojoCopy.build(db.task().findOne(), CTask.class));
                } catch (DBException ex) {
                    logger.error("dump service db connect error");
                    log(db, map("message", "cannot operate " + db.getDbHost() + " server at port " + db.getDbPort()));
                } catch (TException e) {
                    logger.error("dump service error");
                    log(db, map("message", "cannot invoke dump service"));
                    e.printStackTrace();
                }
            }
        });
    }

    private void log(DB db, Map info) {
        Task task = db.task().findOne();
        TaskLog.createLog(task, info);
    }
}
