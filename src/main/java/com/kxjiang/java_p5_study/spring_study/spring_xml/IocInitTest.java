package com.kxjiang.java_p5_study.spring_study.spring_xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 作者: Jiang 创建时间: 2023/2/26 16:01 描述: 加载配置文件，初始化ioc容器测试类
 */
@Data
@Slf4j
public class IocInitTest {

    @Test
    public void getBeanById() {
        // 初始化ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_xml/applicationContext.xml");

        // 1.根据id 从容器中获取bean
        User user = (User)applicationContext.getBean("user");
        log.info(user.toString());
    }

    @Test
    public void getBeanByName() {
        // 初始化ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_xml/applicationContext.xml");

        // 1.根据name 从容器中获取bean
        User user2 = (User)applicationContext.getBean("user2");
        User user3 = (User)applicationContext.getBean("user3");
        log.info(String.valueOf(user2 == user3));
    }

    @Test
    public void getBeanByType() {
        // 初始化ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_xml/applicationContext.xml");

        // 1.根据type 从容器中获取bean
        User user4 = applicationContext.getBean(User.class);
        log.info(user4.toString());
    }

    @Test
    public void getBeanByNameAndType() {
        // 初始化ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_xml/applicationContext.xml");

        // 1.根据name和type 从容器中获取bean
        User user5 = applicationContext.getBean("user2", User.class);
        log.info(user5.toString());
    }

    @Test
    public void getStaticFactoryBeanByIdAndType() {
        // 初始化ioc容器
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("spring_xml/applicationContextFactory.xml");

        // 1.根据id和type 从容器中获取bean
        User user6 = applicationContext.getBean("factoryUser", User.class);
        log.info(user6.toString());
    }

    @Test
    public void getDynamicFactoryBeanByIdAndType() {
        // 初始化ioc容器
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("spring_xml/applicationContextFactory.xml");

        // 1.根据id和type 从容器中获取bean
        User user7 = applicationContext.getBean("dynamicFactoryUser", User.class);
        log.info(user7.toString());
    }

    @Test
    public void getBean() {
        // 初始化ioc容器
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("spring_xml/applicationContext_attribute.xml");

        // 1.根据type 从容器中获取bean
        User user8 = applicationContext.getBean(User.class);
        log.info(user8.toString());
    }
}
