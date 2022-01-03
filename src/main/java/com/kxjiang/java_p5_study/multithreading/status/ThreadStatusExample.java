package com.kxjiang.java_p5_study.multithreading.status;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author kxjiang
 * @date 2022-01-03 18:56:10
 **/
public class ThreadStatusExample {
    public static void main(String[] args) {
        // TIME_WAITING
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"thread-status-time_waiting").start();

        // WAITING
        new Thread(()->{
            while(true){
                synchronized (ThreadStatusExample.class){
                    try {
                        ThreadStatusExample.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"thread-status-waiting").start();
        // BLOCKED
        new Thread(new BlockedDemo(),"thread-status-blocked-1").start();
        new Thread(new BlockedDemo(),"thread-status-blocked-2").start();
    }
    @SuppressWarnings("all")
    static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
