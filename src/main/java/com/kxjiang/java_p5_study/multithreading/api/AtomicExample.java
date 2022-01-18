package com.kxjiang.java_p5_study.multithreading.api;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kxjiang
 * @date 2022-01-18 23:05
 */
public class AtomicExample {
    private static final AtomicInteger count = new AtomicInteger(0);
    public synchronized static void incr(){
        try {
            Thread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicExample::incr).start();
        }
        Thread.sleep(4000);
        System.out.println("result:"+count.get());
    }
}
