package com.kxjiang.java_p5_study.algorithm;

/** 作者: Jiang 创建时间: 2023/1/25 14:29 描述: */
public class 最长递增子序列 {
    public static void main(String[] args) {
        //
        int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        int res = 0;

        for (int j = 0; j < nums.length; j++) {
            f[j] = 1;
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j] && f[i] + 1 > f[j]) {
                    f[j] = f[i] + 1;
                }
            }
            res = Math.max(res, f[j]);
        }
        return res;
    }
}
