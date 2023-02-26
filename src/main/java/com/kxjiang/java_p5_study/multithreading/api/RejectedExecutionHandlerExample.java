package com.kxjiang.java_p5_study.multithreading.api;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author kxjiang 时间: 2022/1/19 描述: 拒绝策略实现类 报警，通知运维人员，并进行相应的处理
 */
public class RejectedExecutionHandlerExample implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("拒绝策略---哈哈");
        throw new RuntimeException("线程池要爆了！");
    }
}
