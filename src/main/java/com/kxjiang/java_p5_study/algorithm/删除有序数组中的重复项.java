package com.kxjiang.java_p5_study.algorithm;

import java.util.Arrays;

/**
 * @author lyh
 * @date 2022-04-08 22:17
 */
public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        // 慢指针
        int slow = 0;
        // 计数器 计是否有两个重复的数
        int count = 0;
        // 快指针
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == nums[fast]) {
                if (count < 1) {
                    count++;
                } else if (count == 1) {
                    slow += 2;
                    nums[slow] = nums[fast + 1];
                    count = 0;
                }
            } else {
                slow++;
            }
        }
        return slow + 1;
    }
}
