package com.kxjiang.java_p5_study.spring_study.spring_xml;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者: Jiang 创建时间: 2023/2/27 21:23 描述: 静态工厂类
 */
public class StaticFactory {

    public static final Map<String, User> userContext = new HashMap<>();

    static {
        userContext.put("user1", new User());
        userContext.put("user2", new User());
        userContext.put("user3", new User());
        userContext.put("user4", new User());
    }

    /**
     * 根据id获取user对象方法
     * 
     * @return 返回user对象
     */
    public static User getUser() {
        return userContext.get("user1");
    }
}
