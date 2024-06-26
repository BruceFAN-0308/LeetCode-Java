package com.bruce.LC.util;

public class Utils {
    public static void logNumbers(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int num : nums[i]) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
