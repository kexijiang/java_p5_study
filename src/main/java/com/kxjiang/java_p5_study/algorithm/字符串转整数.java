package com.kxjiang.java_p5_study.algorithm;

/**
 * 作者: Jiang 创建时间: 2023/1/29 20:54 描述:
 */
public class 字符串转整数 {
    public static void main(String[] args) {
        //
        System.out.println(myAtoi("   -42"));
    }

    public static int myAtoi(String s) {
        if (s.equals("")) {
            return 0;
        }
        if (s.equals("-")) {
            return 0;
        }

        char[] f = s.toCharArray();

        int left = 0;
        int right = 0;
        // 当前是否已读取数字
        boolean isRead = false;

        String fuhao = "";

        for (char value : f) {
            // 忽略前导空格
            if (value == ' ' && !isRead) {
                left++;
            } else if (value == '-' && !isRead) {
                if (!fuhao.equals("")) {
                    break;
                }
                left++;
                fuhao = "-";
            } else if (value == '+' && !isRead) {
                if (!fuhao.equals("")) {
                    break;
                }
                left++;
                fuhao = "+";
            } else if (isDigit(value)) {
                // 是数字
                if (isRead) {
                    right++;
                } else {
                    // 遇到的第一个数字
                    right = left + 1;
                }
                isRead = true;
            } else if (!isDigit(value) && !isRead) {
                return 0;
            } else if (!isDigit(value) && isRead) {
                break;
            }
        }
        if (right < left) {
            return 0;
        }
        String resStr = s.substring(left, right);
        int index = 0;
        for (char c : resStr.toCharArray()) {
            if (c == '0') {
                index++;
            } else {
                break;
            }
        }
        resStr = s.substring(index, resStr.length());

        if (resStr.length() > 10) {
            resStr = resStr.substring(0, 11);
        }
        long res = Long.parseLong(resStr);
        int target = 0;
        if (res > Integer.MAX_VALUE) {
            if (fuhao.equals("-")) {
                target = Integer.MAX_VALUE + 1;
            } else {
                target = Integer.MAX_VALUE;
            }

        } else {
            target = (int)res;
        }

        if (fuhao.equals("-")) {
            return -target;
        }
        return target;
    }

    public static boolean isDigit(char cha) {
        return cha >= '0' && cha <= '9';
    }
}
