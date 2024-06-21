package com.bruce.LC.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 14:45
 **/
public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {

        int count = 1;
        Arrays.sort(intervals, Comparator.comparing(o1 -> o1[1]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        System.out.println(new LC435().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
