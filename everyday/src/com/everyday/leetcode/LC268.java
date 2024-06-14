package com.everyday.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-02-20 16:23
 **/

/*
* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
* */
public class LC268 {

    public static void main(String[] args) {
        System.out.println(new LC268().missingNumber(new int[]{
                9, 6, 4, 2, 3, 5, 7, 0, 1
        }));
    }

    public int missingNumber(int[] nums) {

        int sum = nums.length;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + i - nums[i];
        }

        return sum;
    }
}
