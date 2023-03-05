package com.kxjiang.java_p5_study.spring_study.spring_javaclass;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import lombok.ToString;

/**
 * 作者: Jiang 创建时间: 2023/3/5 14:10 描述: @Value注解案例类
 */
@ToString
public class Environment {
    /**
     * 注入操作系统的信息 可以注入系统的很多信息
     */
    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    /**
     * 注入计算表达式的值
     */
    @Value("#{T(java.lang.Math).random()*100}")
    private double randomNumber;

    /**
     * 注入其他bean的属性 通过该属性的get方法获取值注入到当前类属性中。
     */
    @Value("#{person.name}")
    private String fromPersonName;

    @Value("classpath:applicationContext.xml")
    private Resource resourceFile;

    @Value("https://www.baidu.com")
    private Resource baiduFile;
}
