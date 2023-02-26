package com.kxjiang.java_p5_study.algorithm;

import java.util.Scanner;

/**
 * 作者: Jiang 创建时间: 2023/1/14 10:01 描述:
 */
public class 严格连续递增 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int lang = 1;
        int langMax = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] >= str[i - 1] && (str[i] >= '0' && str[i] <= '9')) {
                lang += 1;
            } else {
                lang = 1;
            }
            langMax = Math.max(lang, langMax);
        }
        System.out.println(langMax);
    }

}
