package com.kxjiang.java_p5_study.multithreading.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author kxjiang
 * @date 2022-01-24 22:37
 */
@SuppressWarnings("all")
public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread((countDownLatch::countDown), "countDownLatch-1").start();
        new Thread((countDownLatch::countDown), "countDownLatch-2").start();
        new Thread((countDownLatch::countDown), "countDownLatch-3").start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
}
