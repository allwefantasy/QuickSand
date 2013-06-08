package net.csdn.service.task;

import net.csdn.modules.threadpool.ThreadPoolService;

import java.util.concurrent.FutureTask;

/**
 * 5/31/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class CSDNFutureTask<T> {
    private FutureTask<T> futureTask;
    private volatile boolean isStarted = false;
    private volatile boolean isFinished = true;
    private volatile boolean isCanceled = false;

    public void start(ThreadPoolService threadPoolService) {
        threadPoolService.executor(ThreadPoolService.Names.CACHED).execute(futureTask);
        isStarted = true;
    }

    public void stop() {
        if (!isStarted || futureTask.isCancelled() || futureTask.isDone()) return;
        isCanceled = futureTask.cancel(true);
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

    public CSDNFutureTask(FutureTask<T> futureTask) {
        this.futureTask = futureTask;
    }
}
