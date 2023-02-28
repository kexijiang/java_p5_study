package com.kxjiang.java_p5_study.spring_study.spring_javaclass;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * 作者: Jiang 创建时间: 2023/2/28 22:36 描述: spring容器获取bean测试类
 */
@Slf4j
public class IocInitTest {
    @Test
    public void getBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            "com.kxjiang.java_p5_study.spring_study.spring_javaclass.JavaConfig");

        User user = (User)applicationContext.getBean("user");
        log.info(user.toString());
    }
}
