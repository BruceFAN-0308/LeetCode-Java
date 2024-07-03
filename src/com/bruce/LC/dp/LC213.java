package com.bruce.LC.dp;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-20 14:13
 **/
public class LC213 {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int first = 0;
        int second = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int current = Math.max(first + nums[i], second);
            first = second;
            second = current;
        }
        int robFirst = second;
        first = 0;
        second = 0;
        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(first + nums[i], second);
            first = second;
            second = current;
        }

        return Math.max(second, robFirst);
    }

    public static void main(String[] args) {
        System.out.println(new LC213().rob(new int[]{1, 2, 3}));
    }
}
