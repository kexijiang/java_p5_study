package com.kxjiang.java_p5_study.multithreading.api;

/**
 * Interrupted()方法案例类
 *
 * @author kxjiang
 * @date 2022-01-03 22:41
 */
@SuppressWarnings("all")
public class InterruptedExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                // 标识该线程被中断过，被中断之后要做的逻辑
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupt before " + Thread.currentThread().isInterrupted());
                    Thread.interrupted(); // 对中断标识进行复位 还原中断标识为初始false状态
                    System.out.println("interrupt before " + Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });
        try {
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
