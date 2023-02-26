package com.kxjiang.java_p5_study.multithreading.api;

/**
 * synchronized关键字案例类
 *
 * @author kxjiang
 * @date 2022-01-05 22:38
 */
@SuppressWarnings("all")
public class SynchronizedExample {
    // 同一时间只允许一个线程执行同一个SynchronizedExample类实例的method方法 --实例级别
    public synchronized void method() {
        synchronized (this) {
            System.out.println("普通方法-对象锁");
        }
    }

    // 同一时间只允许一个线程执行同一个SynchronizedExample类的staticMethod方法 -- 类级别
    public synchronized static void staticMethod() {
        System.out.println("静态方法-类锁");
    }

    public static void main(String[] args) {
        SynchronizedExample syncExample = new SynchronizedExample();
        synchronized (syncExample) {
            System.out.println("同步代码块-对象锁");
        }
        synchronized (SynchronizedExample.class) {
            System.out.println("同步代码块-类锁");
        }
    }
}
