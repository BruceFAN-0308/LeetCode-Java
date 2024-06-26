package com.bruce.LC.sortFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57 {

    // make a new array, intervals + newInterval, and use LC56's solution
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int[][] results = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            results[i] = intervals[i];
        }
        results[intervals.length] = newInterval;
        Arrays.sort(results, (o1, o2) -> o1[0] - o2[0]);


        for (int i = 0; i < results.length; i++) {
            int left = results[i][0];
            int right = results[i][1];
            if (list.isEmpty()) {
                list.add(results[i]);
                continue;
            }
            int[] top = list.get(list.size() - 1);
            if (left > top[1]) {
                list.add(results[i]);
            } else {
                top[1] = Math.max(top[1], right);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    public int[][] insertByBinary(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        // 在 intervals 中查找最后一个右端点小于 newInterval 左端点的区间
        // 该区间（包含）及之前的区间不用合并
        int left = 0;
        int right = n;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (intervals[mid][1] < newInterval[0]) left = mid + 1;
            else right = mid;
        }
        int start = right - 1;
        // 在 intervals 中查找第一个左端点大于 newInterval 右端点的区间
        // 该区间（包含）及之后的区间不用合并
        left = 0;
        right = n;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (intervals[mid][0] > newInterval[1]) right = mid;
            else left = mid + 1;
        }
        int end = left;
        // 合并区间
        int[][] ans = new int[(start + 1) + 1 + (n - end)][2];
        int idx = 0;
        for (int i = 0; i <= start; i++) {
            ans[idx++] = intervals[i];
        }
        ans[idx][0] = Math.min(newInterval[0], start + 1 < n ? intervals[start + 1][0] : newInterval[0]);
        ans[idx++][1] = Math.max(newInterval[1], end - 1 >= 0 ? intervals[end - 1][1] : newInterval[1]);
        for (int i = end; i < n; i++) ans[idx++] = intervals[i];
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(new LC57().insertByBinary(new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        }, new int[]{4, 8}));
//        System.out.println(new LC57().insertByBinary(new int[][]{
//                {1, 3}, {6, 9}
//        }, new int[]{2, 5}));
    }
}
