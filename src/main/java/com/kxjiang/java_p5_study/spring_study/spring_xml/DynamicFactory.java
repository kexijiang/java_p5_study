package com.kxjiang.java_p5_study.spring_study.spring_xml;

/**
 * 作者: Jiang 创建时间: 2023/2/27 21:35 描述: 动态工厂类
 */
public class DynamicFactory {
    /**
     * 获取user对象方法
     * 
     * @return 返回user对象
     */
    public User getUser() {
        return new User();
    }
}
