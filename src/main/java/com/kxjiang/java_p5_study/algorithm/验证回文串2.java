package com.kxjiang.java_p5_study.algorithm;

/** 作者: Jiang 创建时间: 2023/1/25 13:38 描述: */
public class 验证回文串2 {
  public static void main(String[] args) {
    //
    String s = "abca";
    System.out.println(validPalindrome(s));
  }

  public static boolean validPalindrome(String s) {
    // 双指针法
    if ("".equals(s)) {
      return true;
    }

    int left = 0;
    int right = s.length() - 1;
    char[] chars = s.toCharArray();
    while (left < right) {
      if (chars[left] == chars[right]) {
        left++;
        right--;
      } else {
        // 如果左边不等于右边  或者删除左右边一个字符后也不等于另一边
        return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
      }
    }
    return true;
  }

  // 判断两个字符是否相等
  public static boolean validPalindrome(String s, int l, int r) {
    for (int i = l, j = r; i < j; ++i, --j) {
      char c1 = s.charAt(i);
      char c2 = s.charAt(j);
      if (c1 != c2) {
        return false;
      }
    }
    return true;
  }
}
