package com.bruce.LC.sortFirst;

import java.util.Arrays;

public class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                int minus = Math.abs(current - target);
                if (minus < min) {
                    result = current;
                    min = minus;
                }
                if (current > target) {
                    right--;
                } else if (current < target) {
                    left++;
                } else {
                    return current;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC16().threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }
}
