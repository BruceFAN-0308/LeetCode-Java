package com.bruce.LC.daily;

import java.util.Arrays;

public class LC1509 {
    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= 3; i++) {
            ans = Math.min(ans, nums[nums.length - 4 + i] - nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC1509().minDifference(new int[]{1, 5, 0, 10, 14, 17}));
    }
}
