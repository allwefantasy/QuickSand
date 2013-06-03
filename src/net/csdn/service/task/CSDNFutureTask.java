package net.csdn.service.task;

import net.csdn.modules.threadpool.ThreadPoolService;

import java.util.concurrent.FutureTask;

/**
 * 5/31/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class CSDNFutureTask<T> {
    private FutureTask<T> futureTask;
    private volatile boolean isStarted = false;

    public void start(ThreadPoolService threadPoolService) {
        threadPoolService.executor(ThreadPoolService.Names.CACHED).execute(futureTask);
        isStarted = true;
    }

    public void stop() {
        if (!isStarted || futureTask.isCancelled() || futureTask.isDone()) return;
        futureTask.cancel(true);
    }

    public CSDNFutureTask(FutureTask<T> futureTask) {
        this.futureTask = futureTask;
    }
}
