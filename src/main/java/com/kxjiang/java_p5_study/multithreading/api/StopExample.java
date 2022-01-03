package com.kxjiang.java_p5_study.multithreading.api;

/**
 * 线程中止案例类
 *
 * @author kxjiang
 * @date 2022-01-03 22:08
 */
@SuppressWarnings("all")
public class StopExample {

    private static volatile boolean stop = true;

    public static void main(String[] args) throws InterruptedException {
        StopThread stopThread = new StopThread();
        Thread stopThread_1 = new Thread(stopThread,"stopThread-example");
        stopThread_1.start();
        Thread.sleep(1);

        //stopThread_1.stop(); // 类似kill -9 不推荐使用，过时了
        stop = false;
    }
    static class StopThread implements Runnable{

        @Override
        public void run() {
            while (stop){
                System.out.println("持续运行！");
            }
        }
    }
}
