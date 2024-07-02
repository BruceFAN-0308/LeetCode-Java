package com.bruce.LC.daily;

import java.util.Arrays;

public class LC350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int first = 0, second = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) {
                first++;
            } else if (nums1[first] > nums2[second]) {
                second++;
            } else {
                nums1[k] = nums1[first];
                first++;
                second++;
                k++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        for (int i : new LC350().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})) {
            System.out.print(i + " ");
        }
    }
}
