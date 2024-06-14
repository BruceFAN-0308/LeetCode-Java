package com.everyday.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-26 15:44
 **/
/*
* Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
* */
public class LC41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < n && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
        System.out.println(new LC41().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
