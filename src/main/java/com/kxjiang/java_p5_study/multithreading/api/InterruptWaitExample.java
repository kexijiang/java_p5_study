package com.kxjiang.java_p5_study.multithreading.api;

/**
 * interrupt 抛出异常结束线程的案例类
 *
 * @author kxjiang
 * @date 2022-01-03 22:18
 */
public class InterruptWaitExample {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            // 如果该线程始终处于阻塞状态，interrupt方法可以唤醒处于阻塞的线程并抛出一个InterruptedException出来
            // 此时线程中的代码即可捕获该异常，做出自己的处理，或者执行其他代码，或者什么都不执行，就结束线程
            try {
                System.out.println(Thread.currentThread().getName() + "当前时间：" + System.currentTimeMillis());
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "线程被唤醒，捕获了InterruptedException，此时时间：" + System.currentTimeMillis());
            }
        },"interrupt-1");
        try {
            thread.start();
            Thread.sleep(1);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
