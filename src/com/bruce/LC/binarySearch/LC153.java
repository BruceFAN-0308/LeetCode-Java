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

    public static void main(String[] args) {
        System.out.println(new LC153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
