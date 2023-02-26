package com.kxjiang.java_p5_study.algorithm;

import java.util.Arrays;

/**
 * @author kxjiang
 * @date 2022-04-09 21:51
 */
@SuppressWarnings("all")
public class 按奇偶排序数组 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {0, 1})));
    }

    public static int[] sortArrayByParity(int[] nums) {
        // 对撞型双指针

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            boolean left_ji = nums[left] % 2 == 1;
            boolean right_ou = nums[right] % 2 == 0;
            // 如果左边是奇数，右边是偶数，互换
            if (left_ji && right_ou) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
                // 如果左边是奇数，右边也是奇数，右边继续走一步，左边不动
            } else if (left_ji && !right_ou) {
                right--;
            } else if (!left_ji && right_ou) {
                left++;
            } else if (!left_ji && !right_ou) {
                left++;
                right--;
            }
        }
        return nums;
    }
}
