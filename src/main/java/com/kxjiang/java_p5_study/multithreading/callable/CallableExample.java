package com.kxjiang.java_p5_study.multithreading.callable;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author kxjiang
 * 时间: 2021/12/22
 * 描述: Callable案例类
 */
@SuppressWarnings("all")
public class CallableExample implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("当前执行任务线程: "+Thread.currentThread().getName());
        Thread.sleep(4000);
        return "hello world.";
    }

    public static void main(String[] args) throws Exception {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("example-pool-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(1,1,1000, TimeUnit.MINUTES,new ArrayBlockingQueue<>(5),namedThreadFactory);
        Future<String> future = executor.submit(new CallableExample());
        // 当前主线程与开启的子线程无关,主线程等待与否不影响子线程的执行
        Thread.sleep(2000);
        // future.get方法是个阻塞方法,会等待线程执行完毕,如果子线程一直未执行完毕,则会一直阻塞
        System.out.println(future.get());
        executor.shutdown();
    }
}
