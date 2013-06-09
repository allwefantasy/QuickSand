import net.csdn.controller.thrift.CTask;
import net.csdn.document.Task;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

import static net.csdn.common.collections.WowCollections.list;
import static net.csdn.common.collections.WowCollections.map;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class Test {
    public static void main(String[] args) {
//        try {
//            CronExpression cronExpression = new CronExpression("*/5 * * ? * *");
//            System.out.println(cronExpression.getNextValidTimeAfter(new Date()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        System.out.println(JSONObject.fromObject(map(
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
                        "driver", map(
                        "driverName", "com.mysql.jdbc.Driver",
                        "url", "jdbc:mysql://{}:{}/{}?useUnicode=true&characterEncoding=utf8"
                )
                ))
        )).toString());
    }

    public static void testPojoCopy() {

    }

    public static void testCopy() {

//        Task t = Task.create(
//                map(
//                        "name", "test",
//                        "cronTime", "*/5 * * ? * *",
//                        "userName", "allwefantasy",
//                        "created_at", "2013050312",
//                        "dbs", list(
//                        map(
//                                "sql", "select * from cf_conference",
//                                "dbHost", "CsdnTest",
//                                "dbPort", "3306",
//                                "dbUserName", "root",
//                                "dbPassword", "csdn.net",
//                                "dbName", "huiyi",
//                                "prefix", "huiyi",
//                                "dbDriverInfo", map(
//                                "driverName", "com.mysql.jdbc.Driver",
//                                "url", "jdbc:mysql://{}:{}/{}?useUnicode=true&characterEncoding=utf8"
//                        )
//                        ))
//                )
//        );
        Task t = new Task();
        t.setName("jack");
        CTask task = new CTask();
        try {
            BeanUtils.copyProperties(task, t);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
