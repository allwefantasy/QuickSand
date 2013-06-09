package net.csdn.service.task;

import net.csdn.document.Task;
import net.csdn.document.TaskLog;
import net.csdn.modules.threadpool.ThreadPoolService;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static net.csdn.common.collections.WowCollections.map;

/**
 * 5/31/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class CSDNFutureTask<T> {
    private FutureTask<T> futureTask;
    private Callable<T> callable;
    private Task task;
    private volatile boolean isStarted = false;
    private volatile boolean isFinished = true;
    private volatile boolean isCanceled = false;

    public void start(ThreadPoolService threadPoolService) {
        if (futureTask == null || futureTask.isCancelled() || futureTask.isDone()) {
            futureTask = new FutureTask<T>(callable);
        }
        threadPoolService.executor(ThreadPoolService.Names.CACHED).execute(futureTask);
        isStarted = true;
        TaskLog.createLog(task, map("message", "start [" + task.getName() + "] "));
    }

    public void stop() {
        if (!isStarted || futureTask.isCancelled() || futureTask.isDone()) return;
        isCanceled = futureTask.cancel(true);
        TaskLog.createLog(task, map("message", "cancel [" + task.getName() + "] "));
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public boolean isCancel() {
        return isCanceled;
    }

    public CSDNFutureTask(Task task, Callable<T> callable) {
        this.task = task;
        this.callable = callable;
    }
}
