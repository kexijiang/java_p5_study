package com.kxjiang.java_p5_study.algorithm;

/** 作者: Jiang 创建时间: 2023/1/24 10:57 描述: */
public class 有效的回文 {
    /***
     * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 本题中，将空字符串定义为有效的 回文串 。 输入: s = "A man, a plan, a canal: Panama" 输出: true 解释："amanaplanacanalpanama" 是回文串
     *
     * 来源：力扣（LeetCode）
     *
     *
     * 输入: s = "race a car" 输出: false 解释："raceacar" 不是回文串
     */

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }

        StringBuilder str = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            // 如果是数字和字母 ,忽略其他字符
            if (Character.isLetterOrDigit(aChar)) {
                str.append(Character.toLowerCase(aChar));
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}
