package com.everyday.leetcode.daily;

import java.util.*;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-19 12:23
 **/
public class LC1482 {
//    public int minDays(int[] bloomDay, int m, int k) {
//        if (m > bloomDay.length / k) {
//            return -1;
//        }
//        int low = Integer.MAX_VALUE, high = 0;
//        int length = bloomDay.length;
//        for (int i = 0; i < length; i++) {
//            low = Math.min(low, bloomDay[i]);
//            high = Math.max(high, bloomDay[i]);
//        }
//        while (low < high) {
//            int days = (high - low) / 2 + low;
//            if (canMake(bloomDay, days, m, k)) {
//                high = days;
//            } else {
//                low = days + 1;
//            }
//        }
//        return low;
//    }
//
//    public boolean canMake(int[] bloomDay, int days, int m, int k) {
//        int bouquets = 0;
//        int flowers = 0;
//        int length = bloomDay.length;
//        for (int i = 0; i < length && bouquets < m; i++) {
//            if (bloomDay[i] <= days) {
//                flowers++;
//                if (flowers == k) {
//                    bouquets++;
//                    flowers = 0;
//                }
//            } else {
//                flowers = 0;
//            }
//        }
//        return bouquets >= m;
//    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m > bloomDay.length / k) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i : bloomDay) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        while (min < max) {
            int mid = (max - min) / 2 + min;
            if (canMake(bloomDay, m, k, mid)) {
                max = mid;
            } else {
                min = mid+1;
            }
        }


        return min;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flower = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                flower++;
                if (flower == k) {
                    flower = 0;
                    bouquets++;
                }
            } else {
                flower = 0;
            }
        }
        return bouquets >= m;
    }


    public static void main(String[] args) {
        System.out.println(new LC1482().minDays(new int[]{62, 75, 98, 63, 47, 65, 51, 87, 22, 27, 73, 92, 76, 44, 13, 90, 100, 85}, 2, 7));
    }
}
