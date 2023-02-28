package com.kxjiang.java_p5_study.spring_study.spring_xml;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 作者: Jiang 创建时间: 2023/2/26 15:38 描述: 用户类
 */
@Data
@Slf4j
@AllArgsConstructor
public class User {

    private String name;
    private int age;

    private Cat cat;

    private String[] favorites;

    private List<Cat> cats;

    private Map<String, Object> map;

    private Properties properties;

    public User() {
        log.info("user Loading completed...");
    }

    public void init() {
        name = "kxj";
        age = 18;
    };
}
