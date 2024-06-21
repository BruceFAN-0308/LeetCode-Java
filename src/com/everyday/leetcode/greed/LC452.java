package com.everyday.leetcode.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 16:11
 **/
public class LC452 {

    public int findMinArrowShots(int[][] points) {

        int count = 1;

        Arrays.sort(points, Comparator.comparing(o1 -> o1[1]));
        int pointEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= pointEnd) {
                continue;
            }
            pointEnd = points[i][1];
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,2}, {2, 3}, {3,4}, {4, 5}};
        System.out.println(new LC452().findMinArrowShots(points));
    }
}
