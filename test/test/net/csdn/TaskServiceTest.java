package test.net.csdn;

import net.csdn.common.settings.Settings;
import net.csdn.controller.thrift.CTaskLog;
import net.csdn.controller.thrift.DBTaskService;
import net.csdn.junit.IocTest;
import net.csdn.modules.thrift.ThriftClient;
import net.csdn.service.task.TaskService;
import org.apache.thrift.TException;
import org.junit.Test;

import java.util.List;

/**
 * 5/31/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class TaskServiceTest extends IocTest {

    private ThriftClient dbTaskServiceThriftClient;
    private TaskService taskService;
    private Settings settings;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        this.dbTaskServiceThriftClient = ThriftClient.build(DBTaskService.Client.class);
        this.settings = service(Settings.class);
        this.taskService = service(TaskService.class);
    }


//    public void testCreateTask() {
//        Task t = Task.create(
//                map(
//                        "name", "test",
//                        "cronTime", "*/5 * * ? * *",
//                        "userName", "allwefantasy",
//                        "created_at", "2013050312",
//                        "dbs", list(
//                        map(
//                                "sql", "select * from schema_migrations",
//                                "dbHost", "CsdnTest",
//                                "dbPort", "3306",
//                                "dbUserName", "root",
//                                "dbPassword", "csdn.net",
//                                "dbName", "csdn_search_development_v2",
//                                "prefix", "huiyi",
//                                "driver", map(
//                                "driverName", "com.mysql.jdbc.Driver",
//                                "url", "jdbc:mysql://{}:{}/{}?useUnicode=true&characterEncoding=utf8"
//                        )
//                        ))
//                )
//        );
//
//    }

    @Test
    public void testQueryTaskLog() {
        dbTaskServiceThriftClient.execute(settings.getAsArray("thrift.servers.task")[0], new ThriftClient.Callback<DBTaskService.Client>() {
            @Override
            public void execute(DBTaskService.Client client) {
                try {
                    List<CTaskLog> taskLogs = client.queryLog("test", 0, 15);
                    for (CTaskLog taskLog : taskLogs) {
                        System.out.println(taskLog.getMessage());
                    }
                } catch (TException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
