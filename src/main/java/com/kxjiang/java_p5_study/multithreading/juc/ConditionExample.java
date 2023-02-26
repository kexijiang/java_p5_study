package com.kxjiang.java_p5_study.multithreading.juc;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kxjiang
 * 时间: 2022/2/11
 * 描述: Condition案例类
 */
public class ConditionExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        ConditionExampleAwait conditionExampleAwait = new ConditionExampleAwait(lock,condition);
        ConditionExampleSignal conditionExampleSignal = new ConditionExampleSignal(lock,condition);
        conditionExampleAwait.start();
        conditionExampleSignal.start();
    }
    @AllArgsConstructor
    public static class ConditionExampleAwait extends Thread{

        private final Lock lock;
        private final Condition condition;

        @Override
        public void run() {
            System.out.println("begin-condition-await:"+System.currentTimeMillis());
            lock.lock();
            try{
                // 此时会将当前线程放入condition等待队列中,并阻塞,并释放持有的lock锁
                condition.await();
                System.out.println("end-condition-await:"+System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    @AllArgsConstructor
    public static class ConditionExampleSignal extends Thread{

        private final Lock lock;
        private final Condition condition;

        @Override
        public void run() {
            System.out.println("begin-condition-signal:"+System.currentTimeMillis());
            // 由于conditionExampleAwait线程获得了锁,此时当前线程遇到此代码,阻塞,并将自己放入AQS队列,等待conditionExampleAwait线程释放lock锁
            // 当conditionExampleAwait线程执行await方法,释放锁,当前线程执行代码,执行了signal代码时,将在condition队列中的线程放入AQS队列中,等待lock锁的释放,进行重新抢占
            lock.lock();
            try{
                condition.signal();
                System.out.println("end-condition-signal:"+System.currentTimeMillis());
            }finally {
                lock.unlock();
            }
        }
    }
}
