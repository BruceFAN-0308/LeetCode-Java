package com.bruce.LC.slideWindows;

import java.util.Arrays;

public class LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, length = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                length = Math.min(right - left + 1, length);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }

    public int minSubArrayLenByPrefixSumAndBinary(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < n + 1; i++) {
            int findValue = target + sums[i - 1];
            int index = Arrays.binarySearch(sums, findValue);
            if (index < 0) {
                index = -index - 1;
            }
            if (index <= n) {
                ans = Math.min(ans, index - i + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC209().minSubArrayLenByPrefixSumAndBinary(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
