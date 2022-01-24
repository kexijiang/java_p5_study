package com.kxjiang.java_p5_study.multithreading.juc;

import com.kxjiang.java_p5_study.multithreading.api.AtomicExample;
import com.kxjiang.java_p5_study.multithreading.api.RejectedExecutionHandlerExample;
import com.kxjiang.java_p5_study.multithreading.api.ThreadFactoryExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kxjiang
 * 时间: 2022/1/22
 * 描述: juc包的锁案例
 */
public class LockExample {
    private static final ExecutorService executorService =
            new ThreadPoolExecutor(1,1,
                    1000, TimeUnit.MINUTES,
                    new ArrayBlockingQueue<>(10),
                    new ThreadFactoryExample(),new RejectedExecutionHandlerExample());
    public static final int MAXIMUM_ITERATIONS = 1000;
    private static final Lock LOCK = new ReentrantLock();
    private static int count = 0;
    public static void incr(){
        LOCK.lock();// 获得锁
        try {
            Thread.sleep(1);
            count++;
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            LOCK.unlock(); // 释放锁
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < MAXIMUM_ITERATIONS; i++) {
            executorService.execute(LockExample::incr);
        }
        Thread.sleep(4000);
        System.out.println("result:"+count);
    }
}
