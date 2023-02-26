package com.kxjiang.java_p5_study.multithreading.api;

import java.util.Queue;

/**
 * 生产者消费者模型中的生产者案例类
 *
 * @author kxjiang
 * @date 2022-01-03 21:31
 */
@SuppressWarnings("all")
public class Producer implements Runnable {

    private final int size;
    private final Queue<String> bags;

    public Producer(int size, Queue<String> bags) {
        this.size = size;
        this.bags = bags;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            synchronized (bags) {
                while (bags.size() == size) {
                    // 消费队列满了，进行阻塞操作
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("生产者生产 bag = " + i);
                    bags.add("bag" + i);
                    // 唤醒等待当前bags锁的处于阻塞状态的消费者线程
                    bags.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
