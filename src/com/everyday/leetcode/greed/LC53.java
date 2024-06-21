package com.everyday.leetcode.greed;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 21:42
 **/
public class LC53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        int tempTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            tempTotal = tempTotal + nums[i];
            if (tempTotal > max) {
                max = tempTotal;
            }
            if (tempTotal < 0) {
                tempTotal = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LC53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
