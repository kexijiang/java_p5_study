package com.kxjiang.java_p5_study.spring_study.spring_javaclass;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者: Jiang 创建时间: 2023/2/28 22:36 描述: spring容器获取bean测试类
 */
@Slf4j
public class IocInitTest {
    @Test
    public void getBeanByType() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user = applicationContext.getBean("user1", User.class);
        log.info(user.toString());
    }

    @Test
    public void getBeanByName() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user1 = (User) applicationContext.getBean("user1");
        User user2 = (User) applicationContext.getBean("user2");
        log.info(user1.toString());
        log.info(user2.toString());
    }

    @Test
    public void getBeanById() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user = (User) applicationContext.getBean("getTestBeanId");
        log.info(user.toString());
    }

    @Test
    public void testValue() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        Environment environment = applicationContext.getBean(Environment.class);
        log.info(environment.toString());
    }

    @Test
    public void getBeanConditional() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user = (User) applicationContext.getBean("getUserConditionTest");
        log.info(user.toString());
    }

    @Test
    public void testIocSourceCode() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_xml/applicationContext.xml");
    }
}
