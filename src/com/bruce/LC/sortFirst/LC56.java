package com.bruce.LC.sortFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int start = -1;
        for (int i = 0; i < intervals.length - 1; i++) {

            start = i;
            int max = intervals[i][1];
            while (start < intervals.length - 1 && max >= intervals[start + 1][0]) {
                max = Math.max(max, intervals[start + 1][1]);
                start++;
            }
            list.add(new int[]{intervals[i][0], max});
            i = start;
        }
        if (start < intervals.length - 1) {
            list.add(intervals[intervals.length - 1]);
        }

        return list.toArray(new int[list.size()][]);
    }

    public int[][] mergeDoubleIndex(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);


        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < left) {
                list.add(intervals[i]);
            } else {
                int[] interval = list.get(list.size() - 1);
                interval[1] = Math.max(interval[1], right);
            }
        }

        return list.toArray(new int[list.size()][]);
    }


    public static void main(String[] args) {
        new LC56().merge(new int[][]{
                {2, 6}, {1, 3}, {8, 10}, {15, 18}
        });
        new LC56().merge(new int[][]{
                {1, 4}
        });
        new LC56().merge(new int[][]{
                {2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}
        });
    }
}
