package com.kxjiang.java_p5_study.multithreading.api;

import java.util.Arrays;

/**
 * @author kxjiang
 * @date 2022-01-18 23:18
 */
public class ThreadLocalExample {
    public static final ThreadLocal<Integer> localNum = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                int num = localNum.get();
                num += 5;
                localNum.set(num);
                System.out.println(Thread.currentThread().getName() + "->" + num);
            }, "Thread-local-testThread-" + i);
        }
        Arrays.stream(threads).forEach(Thread::start);
    }
}
