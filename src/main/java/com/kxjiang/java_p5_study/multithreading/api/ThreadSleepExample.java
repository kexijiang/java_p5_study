package com.kxjiang.java_p5_study.multithreading.api;

/**
 * sleep()案例类
 * 
 * @author kxjiang
 * @date 2022-01-03 20:56
 */
public class ThreadSleepExample implements Runnable {
    public static void main(String[] args) {
        new Thread(new ThreadSleepExample()).start();
    }

    @Override
    public void run() {
        System.out.println("开始时间：" + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束时间：" + System.currentTimeMillis());
    }
}
