package com.everyday.leetcode;

import java.util.*;

import static java.util.Collections.reverseOrder;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 12:50
 **/
public class LC826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int ans = 0, j = 0, maxProfit = 0;
        for (int w : worker) {
            while (j < n && jobs[j][0] <= w) {
                maxProfit = Math.max(maxProfit, jobs[j++][1]);
            }
            ans += maxProfit;
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(new LC826().maxProfitAssignment(new int[]{2, 17, 19, 20, 24, 29, 33, 43, 50, 51, 57, 67, 70, 72, 73, 75, 80, 82, 87, 90},
                new int[]{6, 7, 10, 17, 18, 29, 30, 31, 34, 39, 40, 42, 48, 54, 57, 78, 78, 78, 83, 88},
                new int[]{12, 9, 11, 41, 11, 87, 48, 6, 48, 93, 76, 73, 7, 50, 55, 97, 47, 33, 46, 10}));
    }
}
