package com.everyday.leetcode.binarySearch;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-19 14:07
 **/
public class LC540 {

    public int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(new LC540().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
