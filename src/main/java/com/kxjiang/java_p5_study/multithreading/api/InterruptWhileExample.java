package com.kxjiang.java_p5_study.multithreading.api;

/**
 * interrupt while循环的案例类
 *
 * @author kxjiang
 * @date 2022-01-03 22:18
 */
public class InterruptWhileExample {
    private static int i;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            // jvm中每个线程都维护了一个interrupt属性，isInterrupted方法默认值未false
            while (!Thread.currentThread().isInterrupted()) {
                i++;
                System.out.println(Thread.currentThread().getName() + " 当前计数：" + i);
            }
        }, "interrupt-1");
        try {
            thread.start();
            Thread.sleep(1);
            // 调用此方法，将interrupt更改为true，调用isInterrupted()方法时就会获得true;
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
