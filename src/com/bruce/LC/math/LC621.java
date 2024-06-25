package com.bruce.LC.math;

import java.util.HashMap;
import java.util.Map;

public class LC621 {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char task : tasks) {
            int count = map.getOrDefault(task, 0) + 1;
            if (max < count) {
                max = count;
            }
            map.put(task, count);
        }
        int minTime = (max - 1) * (n + 1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                minTime++;
            }
        }
        return Math.max(minTime, tasks.length);
    }

    public int leastIntervalDoNotUseMap(char[] tasks, int n) {

        int[] charCount = new int[26];
        int max = 0;
        for (char task : tasks) {
            charCount[task - 'A']++;
            int i = charCount[task - 'A'];
            max = Math.max(i, max);
        }

        int minTime = (max - 1) * (n + 1);
        for (int i : charCount) {
            if (i == max) {
                minTime++;
            }
        }
        return Math.max(minTime, tasks.length);
    }

    public static void main(String[] args) {
        System.out.println(new LC621().leastIntervalDoNotUseMap(new char[]{'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}, 29));
    }
}
