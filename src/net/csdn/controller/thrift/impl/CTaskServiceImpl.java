package net.csdn.controller.thrift.impl;

import net.csdn.controller.thrift.CTask;
import net.csdn.controller.thrift.CTaskLog;
import net.csdn.controller.thrift.CTaskService;
import net.csdn.document.Task;
import net.csdn.modules.thrift.ThriftApplication;
import net.csdn.modules.thrift.util.PojoCopy;
import net.csdn.service.task.TaskService;
import org.apache.thrift.TException;

import java.util.List;

/**
 * 6/8/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class CTaskServiceImpl extends ThriftApplication implements CTaskService.Iface {

    private TaskService taskService = service(TaskService.class);

    @Override
    public boolean createTask(CTask task) throws TException {
        Task localTask = PojoCopy.build(task, Task.class);
        if (!localTask.valid()) return false;
        taskService.createTask(localTask);
        return true;
    }

    @Override
    public boolean startTask(String name) throws TException {
        taskService.startTask(name);
        return true;
    }

    @Override
    public boolean cancelTask(String name) throws TException {
        taskService.cancelTask(name);
        return true;
    }

    @Override
    public CTask findTask(String name) throws TException {
        return Task.findById(name);
    }

    @Override
    public List<CTask> listTask() throws TException {
        return PojoCopy.buildAll(Task.findAll(), CTask.class);
    }

    @Override
    public void removeTask(String name) throws TException {
        Task task = Task.findById(name);
        if (task != null) task.remove();
    }

    @Override
    public List<CTaskLog> queryLog(String name, int start, int size) throws TException {
        return PojoCopy.buildAll(taskService.queryLog(name, start, size), CTaskLog.class);
    }
}
