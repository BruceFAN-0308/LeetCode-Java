package com.bruce.LC.sortFirst;

public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] results = new int[m + n];

        int i = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                results[i] = nums1[m - 1];
                m--;
            } else {
                results[i] = nums2[n - 1];
                n--;
            }
            i--;
        }
        while (m > 0) {
            results[i] = nums1[m - 1];
            i--;
            m--;
        }
        while (n > 0) {
            results[i] = nums2[n - 1];
            i--;
            n--;
        }

        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = results[j];
        }


    }

    public static void main(String[] args) {
        int[] results = {1, 2, 3, 0, 0, 0};
        new LC88().merge(results, 3, new int[]{2, 5, 6}, 3);
        for (int result : results) {
            System.out.println(result + " ");
        }
    }
}
