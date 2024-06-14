package com.everyday.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-28 10:31
 **/
/*
* You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.
* */

public class LC2958 {

    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.get(nums[i]) > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                j++;
            }

            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new LC2958().maxSubarrayLength(new int[]{2, 11}, 1));
        System.out.println(new LC2958().maxSubarrayLength(new int[]{1, 2, 2, 2}, 2));
    }

}
