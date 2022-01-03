package com.kxjiang.java_p5_study.multithreading.api;

import java.util.Queue;

/**
 * 生产者消费者模型中的消费者案例类
 *
 * @author kxjiang
 * @date 2022-01-03 21:31
 */
@SuppressWarnings("all")
public class Consumer implements Runnable{

    private final int size;
    private final Queue<String> bags;

    public Consumer(int size, Queue<String> bags) {
        this.size = size;
        this.bags = bags;
    }

    @Override
    public void run() {
        int i = 0;
        while(true){
            i++;
            synchronized (bags){
                while (bags.isEmpty()){
                    System.out.println("bags为空！");
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                    String bag = bags.remove();
                    System.out.println("消费者消费：" + bag);
                    // 唤醒等待bags锁的生产者的处于阻塞状态的线程
                    bags.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
