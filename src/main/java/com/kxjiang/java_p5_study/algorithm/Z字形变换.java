package com.kxjiang.java_p5_study.algorithm;

/**
 * @author kxjiang
 * @date 2022-03-30 23:13
 */
@SuppressWarnings("all")
public class Z字形变换 {
    public static void main(String[] args) {

    }
    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        // 循环一个z字形的周期
        int t = r * 2 - 2;

        // 矩阵的列数
        int c = (n + t - 1) / t * (r - 1);

        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);

            // 取余除周期 小于列数减一
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
