package com.kxjiang.java_p5_study.spring_study.spring_javaclass;

import org.springframework.stereotype.Component;

/**
 * 作者: Jiang 创建时间: 2023/3/5 14:19 描述: person类
 */
@Component(value = "person")
public class Person {
    public String name = "testName";

    public String getName() {
        return name;
    }
}
