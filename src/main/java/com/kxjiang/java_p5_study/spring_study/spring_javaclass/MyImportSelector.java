package com.kxjiang.java_p5_study.spring_study.spring_javaclass;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 作者: Jiang 创建时间: 2023/3/5 18:41 描述: import注解的选择器，可以选择注入哪些类
 */
public class MyImportSelector implements ImportSelector {
    // 返回值是要放入ioc容器的类全路径名数组
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {Person.class.getName(), Environment.class.getName()};
    }
}
