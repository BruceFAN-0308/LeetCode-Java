package com.everyday.leetcode;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-27 14:20
 **/
public class LC713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0, right = 0, n = nums.length, product = 1, count = 0;

        while (right < n) {
            product = product * nums[right];
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            count = count + 1 + (right - left);
            right++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new LC713().numSubarrayProductLessThanK(new int[]{ 3, 3, 6, 2}, 19));
//        System.out.println(new LC713().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
