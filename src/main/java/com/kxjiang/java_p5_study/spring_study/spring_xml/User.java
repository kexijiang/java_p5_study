package com.kxjiang.java_p5_study.spring_study.spring_xml;

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

    public User() {
        log.info("user Loading completed...");
    }

    public void init() {
        name = "kxj";
        age = 18;
    };
}
