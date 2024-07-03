package com.bruce.LC.binarySearch;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-19 16:00
 **/
public class LC153 {


    /*
     * have to use  nums[midIndex] > nums[end], because we can make sure whatever we move the start and end
     * the left list and right list are always ascending sorted.
     * */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int midIndex = (end - start) / 2 + start;
            if (nums[midIndex] > nums[end]) {
                start = midIndex + 1;
            } else {
                end = midIndex;
            }
        }

        return nums[start];
    }

    public int findMin1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int midIndex = (right - left) / 2 + left;
            if (nums[midIndex] > nums[right]) {
                left = midIndex + 1;
            } else {
                right = midIndex;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new LC153().findMin1(new int[]{3, 1, 2}));
    }
}
