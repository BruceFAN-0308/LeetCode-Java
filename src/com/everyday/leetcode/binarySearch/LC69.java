package com.everyday.leetcode.binarySearch;

import com.everyday.leetcode.greed.LC665;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 22:11
 **/
public class LC69 {

    public int mySqrt(int x) {

        long start = 1;
        long end = x;

        while (start <= end) {
            long binary = (start + end) / 2;
            if (binary * binary == x) {
                return (int) binary;
            } else if (binary * binary > x) {
                end = binary - 1;
            } else {
                start = binary + 1;
            }
        }

        return Math.round(end);
    }

    public static void main(String[] args) {
        System.out.println(new LC69().mySqrt(2147483647));
    }
}
