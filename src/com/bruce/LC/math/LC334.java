package com.bruce.LC.math;

public class LC334 {

    // the function is find a value 'third', third > second > first
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(new LC334().increasingTriplet(new int[]{1, 5, 0, 4, 1, 3}));
    }
}
