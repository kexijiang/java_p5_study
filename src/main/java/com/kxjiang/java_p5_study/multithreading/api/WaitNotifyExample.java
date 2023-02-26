package com.kxjiang.java_p5_study.multithreading.api;

import java.util.LinkedList;
import java.util.Queue;

/**
 * wait-notify机制案例类
 *
 * @author kxjiang
 * @date 2022-01-03 21:50
 */
public class WaitNotifyExample {
    public static void main(String[] args) {
        Queue<String> bags = new LinkedList<>();
        int size = 5;
        Producer producer = new Producer(size, bags);
        Consumer consumer = new Consumer(size, bags);
        new Thread(producer, "producer").start();
        new Thread(consumer, "consumer").start();
    }
}
