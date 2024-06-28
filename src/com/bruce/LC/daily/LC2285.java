package com.bruce.LC.daily;

import java.util.Arrays;

public class LC2285 {
    public long maximumImportance(int n, int[][] roads) {
        long result = 0;

        long[] nums = new long[n];

        for (int[] road : roads) {
            for (int i : road) {
                nums[i]++;
            }
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            result = result + nums[i] * (i + 1);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new LC2285().maximumImportance(5, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}
        }));
    }
}
