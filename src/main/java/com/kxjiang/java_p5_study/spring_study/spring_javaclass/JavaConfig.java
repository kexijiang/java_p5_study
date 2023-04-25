package com.kxjiang.java_p5_study.spring_study.spring_javaclass;

import org.springframework.context.annotation.*;

/**
 * 作者: Jiang 创建时间: 2023/2/28 22:33 描述: java配置类，相当于appcationContext.xml
 */
@Configuration
@Import(MyImportSelector.class)
public class JavaConfig {

    /**
     * 注入ioc容器中一个user的bean，与xml文件中的<bean>标签是相同的效果 默认的id是方法名称
     *
     * @return 返回要注入到ioc容器中的bean
     */
    @Bean(name = {"user1", "user2"})
    @Scope("singleton")
    public User getUser() {
        return new User();
    }

    /**
     * 注入ioc容器中一个user的bean，与xml文件中的<bean>标签是相同的效果 默认的id是方法名称
     *
     * @return 返回要注入到ioc容器中的bean
     */
    @Bean
    @Profile("dev")
    public User getTestBeanId() {
        return new User();
    }

    @Bean
    @Conditional(ConditionOnBean.class)
    public User getUserConditionTest() {
        return new User();
    }
}
