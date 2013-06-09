package test.net.csdn;

import net.csdn.controller.thrift.CTask;
import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.junit.IocTest;
import net.csdn.modules.thrift.util.PojoCopy;
import net.csdn.service.dump.DBDumper;
import net.csdn.service.task.TaskService;
import net.sf.json.JSONObject;
import org.junit.Test;

import static net.csdn.common.collections.WowCollections.list;
import static net.csdn.common.collections.WowCollections.map;

/**
 * 6/3/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DumpServiceTest extends IocTest {
    private DBDumper crawler;
    private TaskService taskService;
    private Task task;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        crawler = service(DBDumper.class);
        taskService = service(TaskService.class);
        task = Task.create(
                map(
                        "name", "test",
                        "cronTime", "0 */1 * ? * *",
                        "userName", "allwefantasy",
                        "created_at", "2013050312",
                        "dbs", list(
                        map(
                                "sql", "select * from cf_conference",
                                "dbHost", "CsdnTest",
                                "dbPort", "3306",
                                "dbUserName", "root",
                                "dbPassword", "csdn.net",
                                "dbName", "huiyi",
                                "prefix", "cf_conference",
                                "driver", map(
                                "driverName", "com.mysql.jdbc.Driver",
                                "url", "jdbc:mysql://{}:{}/{}?useUnicode=true&characterEncoding=utf8"
                        )
                        ))
                )
        );
    }

    //@Test
    public void query() throws Exception {
        DB db = task.dbs().findOne();
        crawler.dump(db);
    }

    @Test
    public void testCopy() {
        CTask cTask = new CTask();
        PojoCopy.copyProperties(task, cTask);
        Task task2 = new Task();
        Task task3 = Task.create(JSONObject.fromObject(cTask));
        PojoCopy.copyProperties(cTask, task2);
        System.out.println("");
    }
}
