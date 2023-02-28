package com.kxjiang.java_p5_study.spring_study.spring_xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 作者: Jiang 创建时间: 2023/2/28 22:07 描述: 猫实体
 */
@Data
@AllArgsConstructor
@Slf4j
public class Cat {
    private String nike;
    private String color;

    public Cat() {
        log.info("cat init...");
    }
}
