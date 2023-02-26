package com.kxjiang.java_p5_study.multithreading.api;

/**
 * @author kxjiang 时间: 2022/1/19 描述: 双重检查锁的问题
 */
@SuppressWarnings("all")
public class VolatileSyncExample {

    private VolatileSyncExample() {}

    private VolatileSyncExample instance = null;

    /**
     * DCL double check lock
     *
     * instance = new VolatileSyncExample();
     *
     * 1.memory=allocate() 2.ctorInstance(memory) 3.instance=memory
     *
     * 2步骤和3步骤没有依赖关系，可以重排序，如果发生重排序，第三步执行完毕，instance！=null， 但是第二步还未执行完毕，对象的一些方法，变量还未构造完成，就会导致拿到的是未实例化完成的实例，出现异常结果。
     * 
     * @return 返回单例实例对象
     */
    public VolatileSyncExample getInstance() {
        if (instance == null) {
            synchronized (VolatileSyncExample.class) {
                if (instance == null) {
                    instance = new VolatileSyncExample();
                }
            }
        }
        return instance;
    }
}
