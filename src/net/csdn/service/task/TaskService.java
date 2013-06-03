package net.csdn.service.task;

import net.csdn.annotation.Service;
import net.csdn.document.Task;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
@Service(implementedBy = TaskServiceImpl.class )
public interface TaskService {
    public Task createTask(Task task);

    public void resumeTasks();

    public void cancelTask(String name);

    public void startTask(String name);
}
