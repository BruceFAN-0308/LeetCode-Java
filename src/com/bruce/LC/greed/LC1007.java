package com.bruce.LC.greed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < tops.length; i++) {
            map.putIfAbsent(tops[i], new HashSet<>());
            map.putIfAbsent(bottoms[i], new HashSet<>());
            map.get(tops[i]).add(i);
            map.get(bottoms[i]).add(i);
        }

        int num = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == tops.length) {
                num = entry.getKey();
                break;
            }
        }

        if (num == 0) {
            return -1;
        }

        int topAns = 0;
        int bottomAns = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != num) {
                topAns++;
            }
            if (bottoms[i] != num) {
                bottomAns++;
            }
        }

        return Math.min(topAns, bottomAns);
    }

    public int minDominoRotations1(int[] tops, int[] bottoms) {
        int n = tops.length, ans = n + 1;
        int[] topMap = new int[7];
        int[] bottomMap = new int[7];
        int[] sameValueMap = new int[7];
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == bottoms[i]) {
                sameValueMap[tops[i]]++;
            }
            topMap[tops[i]]++;
            bottomMap[bottoms[i]]++;
        }
        for (int i = 0; i < topMap.length; i++) {
            int count = topMap[i] + bottomMap[i] - sameValueMap[i];
            if (count >= n) {
                ans = Math.min(ans, n - Math.max(topMap[i], bottomMap[i]));
            }
        }

        return ans == n + 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC1007().minDominoRotations1(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}));
    }
}
