package com.bruce.LC.dp;

public class LC413 {


    // double index + sliding window
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            int firstLength = nums[i + 1] - nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int secondLength = nums[j + 1] - nums[j];
                if (firstLength == secondLength) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    // dynamic programming
    public int numberOfArithmeticSlicesByDP(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];

        dp[0] = 0;
        dp[1] = 0;
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC413().numberOfArithmeticSlicesByDP(new int[]{1, 2, 3, 3, 3, 4, 5}));
    }
}
