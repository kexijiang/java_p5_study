package com.kxjiang.java_p5_study.multithreading.threadpool;

import com.kxjiang.java_p5_study.multithreading.api.RejectedExecutionHandlerExample;
import com.kxjiang.java_p5_study.multithreading.api.ThreadFactoryExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author kxjiang
 * 时间: 2022/2/11
 * 描述: java提供的四种线程池案例类
 */
@SuppressWarnings("all")
public class ThreadPoolExample implements Runnable{
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorServiceCached = Executors.newCachedThreadPool();
//        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();
//        ExecutorService executorServiceScheduled = Executors.newScheduledThreadPool(2);
//        for (int i = 0; i < 100; i++) {
//            executorService.execute(new ThreadPoolExample());
//        }
//        executorService.shutdown();

        ThreadPoolSelf threadPoolSelf = new ThreadPoolSelf(10,10,100, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),new ThreadFactoryExample(),new RejectedExecutionHandlerExample());
        for (int i = 0; i < 10; i++) {
            threadPoolSelf.execute(new ThreadPoolExample());
        }
        threadPoolSelf.shutdown();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("++++"+Thread.currentThread().getName());
    }
}
