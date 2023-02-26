package com.kxjiang.java_p5_study.multithreading.threadpool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author kxjiang
 * @date 2022-03-03 22:47
 */
public class ThreadPoolSelf extends ThreadPoolExecutor {

    private static long startTime;

    public ThreadPoolSelf(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
        BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("线程数：" + this.getPoolSize());
        System.out.println("核心线程数：" + this.getCorePoolSize());
        System.out.println("正在执行的线程任务数：" + this.getActiveCount());
        System.out.println("已经执行完毕的线程任务数：" + this.getCompletedTaskCount());
        long endTime = System.currentTimeMillis();
        System.out.println("任务耗时：" + (endTime - startTime));
        Map<Integer, Integer> map = new HashMap<>(2);
    }
}
