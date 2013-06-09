package net.csdn.document;

import net.csdn.mongo.Document;
import org.joda.time.DateTime;

import java.util.Map;

import static net.csdn.common.collections.WowCollections.map;

/**
 * 6/9/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class TaskLog extends Document {

    static {
        storeIn("task_logs");
        index(map("taskName", -1), map());
    }


    public static void createLog(Task task, Map info) {
        info.put("taskName", task.getName());
        info.put("time", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        TaskLog taskLog = create(info);
        taskLog.save();
    }

    private String taskName;
    private String message;
    private String time;


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
