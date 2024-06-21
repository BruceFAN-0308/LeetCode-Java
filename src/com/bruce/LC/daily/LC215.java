package com.bruce.LC.daily;

import java.util.Arrays;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-17 16:11
 **/
public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];

    }

    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickselect(nums, l, j, k);
        else return quickselect(nums, j + 1, r, k);
    }

    public int findKthLargestByQuickSort(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{2,1};
//        System.out.println(new LC215().findKthLargestByQuickSort(arr, 1));
        int[] arr = new int[]{19, 28, 8, 23, 10, 21, 9};
        System.out.println(new LC215().findKthLargestByQuickSort(arr, 3));

    }
}
