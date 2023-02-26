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
    public void initIoc() {
        // 初始化ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_xml/applicationContext.xml");
        // 从容器中获取bean
        User user = applicationContext.getBean(User.class);
        log.info(user.toString());
    }
}
