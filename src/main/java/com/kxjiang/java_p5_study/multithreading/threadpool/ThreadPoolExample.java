package com.kxjiang.java_p5_study.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kxjiang
 * 时间: 2022/2/11
 * 描述: java提供的四种线程池案例类
 */
@SuppressWarnings("all")
public class ThreadPoolExample implements Runnable{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorServiceCached = Executors.newCachedThreadPool();
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();
        ExecutorService executorServiceScheduled = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ThreadPoolExample());
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
