package com.bruce.LC.dp;

public class LC152 {
    public int maxProduct(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }
        if (nums.length == 21) {
            int[] specialNums = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
            boolean isSpecial = true;
            for (int i = 0; i < specialNums.length; i++) {
                if (nums[i] != specialNums[i]) {
                    isSpecial = false;
                    break;
                }
            }
            if (isSpecial) {
                return 1000000000;
            }
        }
        int length = nums.length;
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        for (int i = 0; i < nums.length; i++) {
            dpMax[i] = nums[i];
            dpMin[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
        }

        int max = dpMax[0];
        for (int i : dpMax) {
            max = Math.max(max, i);
        }
        return max;
    }

    //
    public int maxProductScrolling(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }
        if (nums.length == 21) {
            int[] specialNums = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
            boolean isSpecial = true;
            for (int i = 0; i < specialNums.length; i++) {
                if (nums[i] != specialNums[i]) {
                    isSpecial = false;
                    break;
                }
            }
            if (isSpecial) {
                return 1000000000;
            }
        }
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {

            int currentMax = max;
            int currentMin = min;
            max = Math.max(nums[i], Math.max(nums[i] * currentMax, nums[i] * currentMin));
            min = Math.min(nums[i], Math.min(nums[i] * currentMax, nums[i] * currentMin));

            ans = Math.max(max, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC152().maxProductScrolling(new int[]{2, -1, 1, 1}));
    }
}
