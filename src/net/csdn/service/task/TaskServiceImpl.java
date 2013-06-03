package net.csdn.service.task;

import com.google.inject.Inject;
import net.csdn.common.collect.Tuple;
import net.csdn.common.logging.CSLogger;
import net.csdn.common.logging.Loggers;
import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.modules.threadpool.ThreadPoolService;
import net.csdn.service.dump.DBCrawler;
import net.csdn.util.cron.CronExpression;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;


/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class TaskServiceImpl implements TaskService {

    private CSLogger logger = Loggers.getLogger(TaskServiceImpl.class);
    private static final Map<String, Tuple<CronExpression, Task>> triggers = new ConcurrentHashMap<String, Tuple<CronExpression, Task>>();
    private static final Map<String, CSDNFutureTask<Boolean>> scheduleThreads = new ConcurrentHashMap<String, CSDNFutureTask<Boolean>>();

    private DBCrawler crawler;
    private ThreadPoolService threadPoolService;

    @Inject
    public TaskServiceImpl(DBCrawler crawler, ThreadPoolService threadPoolService) {
        this.crawler = crawler;
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

    public void removeTask(String name) {
        cancelTask(name);
        triggers.remove(name);
        scheduleThreads.remove(name);
    }

    @Override
    public void resumeTasks() {
        for (Map.Entry<String, Tuple<CronExpression, Task>> entry : triggers.entrySet()) {
            CSDNFutureTask<Boolean> futureTask = scheduleThreads.get(entry.getKey());
            futureTask.start(threadPoolService);
        }
    }

    @Override
    public void cancelTask(String name) {
        scheduleThreads.get(name).stop();
    }

    @Override
    public void startTask(String name) {
        scheduleThreads.get(name).start(threadPoolService);
    }

    private void initialize() {
        List<Task> taskList = Task.findAll();
        for (Task task : taskList) {
            addTrigger(task);
        }
    }

    private void addTrigger(final Task task) {
        try {
            if (triggers.containsKey(task.getName())) {
                cancelTask(task.getName());
            }
            triggers.put(task.getName(), new Tuple<CronExpression, Task>(new CronExpression(task.getCronTime()), task));
            scheduleThreads.put(task.getName(), new CSDNFutureTask<Boolean>(new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    CronExpression cronExpression = triggers.get(task.getName()).v1();
                    Date nextValidTime = cronExpression.getNextValidTimeAfter(new Date());
                    while (nextValidTime != null) {
                        while (new DateTime(nextValidTime).isAfterNow()) {
                            Thread.currentThread().sleep(30 * 1000);
                        }
                        List<DB> dbs = task.dbs().find();
                        for (DB db : dbs) {
                            crawler.query(db);
                        }
                        nextValidTime = cronExpression.getNextValidTimeAfter(new Date());
                    }

                    return true;
                }
            })));
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error("task [" + task.getName() + "] cron expression [" + task.getCronTime() + "] error");
        }
    }
}
