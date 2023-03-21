package com.kxjiang.java_p5_study.spring_study.spring_javaclass;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 作者: Jiang 创建时间: 2023/3/17 21:51 描述: 条件注解测试类
 */
public class ConditionOnBean implements Condition {
    /**
     * 匹配方法
     * 
     * @param context 环境上下文信息
     * @param metadata 元数据信息
     * @return 返回true则注入该bean对象，false不注入该对象
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}
