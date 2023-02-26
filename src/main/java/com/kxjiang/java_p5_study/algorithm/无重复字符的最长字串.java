package com.kxjiang.java_p5_study.algorithm;

/**
 * 作者: Jiang 创建时间: 2023/2/11 17:59 描述:
 */
public class 无重复字符的最长字串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int left = 0;
        int right = 1;

        int res = 1;
        int index = 0;
        while (right < s.length() && left <= right) {
            // 判断right所在位置字符是否在窗口中
            index = left + s.substring(left, right).indexOf(s.charAt(right));
            if (s.charAt(right) == s.charAt(left) && left != right) {
                left++;
                res = Math.max(res, right - left + 1);
            } else if (index != -1) {
                left = index + 1;
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                right++;
                res = Math.max(res, right - left);
            }
        }
        return res;
    }
}
