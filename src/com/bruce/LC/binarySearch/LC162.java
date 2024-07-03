package com.bruce.LC.binarySearch;

public class LC162 {
    public int findPeakElement(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }


        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LC162().findPeakElement(new int[]{3, 4, 3, 2, 1}));
    }
}
