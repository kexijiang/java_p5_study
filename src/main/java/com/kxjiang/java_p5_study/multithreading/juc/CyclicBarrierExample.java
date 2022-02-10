package com.kxjiang.java_p5_study.multithreading.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author kxjiang
 * @date 2022-02-07 22:19
 */
@SuppressWarnings("all")
public class CyclicBarrierExample extends Thread{
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new CyclicBarrierExample());

        new DataImportThread("path1",cyclicBarrier).start();
        new DataImportThread("path2",cyclicBarrier).start();
        new DataImportThread("path3",cyclicBarrier).start();
        // 三个线程执行结束，进行汇总处理
    }

    @Override
    public void run() {
        System.out.println("开始进行数据汇总");
    }

    public static class DataImportThread extends Thread{
        private String path;
        private CyclicBarrier cyclicBarrier;
        public DataImportThread(String path,CyclicBarrier cyclicBarrier) {
            this.path = path;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("开始导入"+path+"位置的数据！");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
