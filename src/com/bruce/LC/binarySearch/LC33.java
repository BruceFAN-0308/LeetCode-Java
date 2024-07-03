package com.bruce.LC.binarySearch;

public class LC33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                // if target is not in this sorted array, let right = mid + 1
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // if target is not in this sorted array, let right = mid - 1
                if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new LC33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
