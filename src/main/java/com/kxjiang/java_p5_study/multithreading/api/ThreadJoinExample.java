package com.kxjiang.java_p5_study.multithreading.api;

/**
 * join方法案例类
 *
 * @author kxjiang
 * @date 2022-01-03 19:12
 */
public class ThreadJoinExample {
    public static int a = 0;
    public static int b = 0;

    public static void main(String[] args) {
        Thread thread_1 = new Thread(() -> {
            a = 1;
            b = 2;
        }, "thread-1");

        Thread thread_2 = new Thread(() -> a = b + 2, "thread-2");

        thread_1.start();
        try {
            thread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread_2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result a:" + a);
    }
}
