package com.bruce.LC.daily;

import java.util.HashMap;
import java.util.Map;

public class LC1791 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            for (int i : edge) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        int maxKey = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    // because edges[0] and edges[1] must have a value is same, so just find this value is the answer
    public int findCenterMath(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        System.out.println(new LC1791().findCenter(new int[][]{
                {1, 2}, {5, 1}, {1, 3}, {1, 4}
        }));
    }
}
