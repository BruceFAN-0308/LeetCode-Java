package com.everyday.leetcode.greed;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 21:18
 **/
public class LC665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int k = 1;

        for (int i = 1; i < nums.length && k >= 0; i++) {
            if (nums[i - 1] > nums[i]) {
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
                k--;
            }
        }

        return k >= 0;
    }

    public static void main(String[] args) {
        System.out.println(new LC665().checkPossibility(new int[]{4, 2, 3}));
    }
}
