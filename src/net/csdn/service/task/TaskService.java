package net.csdn.service.task;

import net.csdn.annotation.Service;
import net.csdn.document.Task;
import net.csdn.document.TaskLog;

import java.util.List;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
@Service(implementedBy = TaskServiceImpl.class)
public interface TaskService {
    public Task createTask(Task task);

    public boolean resumeTasks();

    public boolean cancelTask(String name);

    public boolean startTask(String name);

    public boolean removeTask(String name);

    public List<TaskLog> queryLog(String name, int size, int start);
}
