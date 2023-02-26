package com.kxjiang.java_p5_study.multithreading.juc;

import java.util.concurrent.Semaphore;

/**
 * @author kxjiang
 * @date 2022-02-07 21:43
 */
@SuppressWarnings("all")
public class SemaphoreExample {
    public static void main(String[] args) {
        // 当前可以获得的最大许可数量是5个
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Thread(new Car(i + 1, semaphore)).start();
        }
    }

    public static class Car extends Thread {
        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第" + num + "辆车来了！");
                Thread.currentThread().sleep(2000);
                System.out.println("第" + num + "辆车走了！");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
