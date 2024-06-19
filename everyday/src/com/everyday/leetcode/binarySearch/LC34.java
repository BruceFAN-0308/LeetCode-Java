package com.everyday.leetcode.binarySearch;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-19 16:48
 **/
public class LC34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] ints = {-1, -1};
        int start = 0;
        int end = nums.length - 1;


        // binary search twice
        while (start <= end) {


            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ints[0] = mid;
                end = mid - 1;
            }
        }

        start = 0;
        end = nums.length - 1;

        while (start <= end) {


            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ints[1] = mid;
                start = mid + 1;
            }
        }

        return ints;
    }



    public static void main(String[] args) {
        for (int i : new LC34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)) {
            System.out.println(i);
        }
    }
}
