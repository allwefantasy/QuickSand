import net.csdn.util.cron.CronExpression;

import java.text.ParseException;
import java.util.Date;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class Test {
    public static void main(String[] args) {
        try {
            CronExpression cronExpression = new CronExpression("*/5 * * ? * *");
            System.out.println(cronExpression.getNextValidTimeAfter(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
