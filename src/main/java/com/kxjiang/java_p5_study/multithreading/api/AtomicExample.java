package com.kxjiang.java_p5_study.multithreading.api;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kxjiang
 * @date 2022-01-18 23:05
 */
@SuppressWarnings("all")
public class AtomicExample {

    private static final ExecutorService executorService =
            new ThreadPoolExecutor(1,1,
                    1000, TimeUnit.MINUTES,
                    new ArrayBlockingQueue<>(10),
                    new ThreadFactoryExample(),new RejectedExecutionHandlerExample());

    private static final AtomicInteger COUNT = new AtomicInteger(0);
    public synchronized static void incr(){
        try {
            Thread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        COUNT.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            executorService.execute(AtomicExample::incr);
        }
        Thread.sleep(4000);
        System.out.println("result:"+COUNT.get());
    }
}
