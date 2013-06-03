package test.net.csdn;

import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.junit.IocTest;
import net.csdn.service.dump.DBCrawler;
import net.csdn.service.task.TaskService;
import org.junit.Test;

import static net.csdn.common.collections.WowCollections.list;
import static net.csdn.common.collections.WowCollections.map;

/**
 * 6/3/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DumpServiceTest extends IocTest {
    private DBCrawler crawler;
    private TaskService taskService;
    private Task task;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        crawler = service(DBCrawler.class);
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
                                "dbDriverInfo", map(
                                "driverName", "com.mysql.jdbc.Driver",
                                "url", "jdbc:mysql://{}:{}/{}?useUnicode=true&characterEncoding=utf8"
                        )
                        ))
                )
        );
    }

    @Test
    public void query() throws Exception {
        DB db = task.dbs().findOne();
        crawler.query(db);
    }
}
