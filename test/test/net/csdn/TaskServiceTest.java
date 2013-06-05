package test.net.csdn;

import junit.framework.Assert;
import net.csdn.document.Task;
import net.csdn.junit.IocTest;
import net.csdn.service.task.TaskService;
import org.junit.Test;

import static net.csdn.common.collections.WowCollections.list;
import static net.csdn.common.collections.WowCollections.map;

/**
 * 5/31/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class TaskServiceTest extends IocTest {

    private TaskService taskService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        taskService = service(TaskService.class);
    }


    @Test
    public void testCreateTask() {
        Task t = Task.create(
                map(
                        "name", "test",
                        "cronTime", "*/5 * * ? * *",
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
                                "prefix", "huiyi",
                                "dbDriverInfo", map(
                                "driverName", "com.mysql.jdbc.Driver",
                                "url", "jdbc:mysql://{}:{}/{}?useUnicode=true&characterEncoding=utf8"
                        )
                        ))
                )
        );
        taskService.createTask(t);
        Task newTask = Task.findById("test");
        Assert.assertTrue(newTask != null);
        taskService.startTask("test");
        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Task task = Task.findById("test");
        task.remove();
    }
}
