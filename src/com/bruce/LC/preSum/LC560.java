package com.bruce.LC.preSum;

import java.util.HashMap;
import java.util.Map;

public class LC560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LC560().subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }
}
