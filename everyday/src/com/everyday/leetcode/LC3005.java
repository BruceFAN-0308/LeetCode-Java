package com.everyday.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-08 16:20
 **/
public class LC3005 {
    public static void main(String[] args) {
        System.out.println(new LC3005().maxFrequencyElements(new int[]{10, 12, 11, 9, 6, 19, 11}));
    }

    public int maxFrequencyElements(int[] nums) {

        int sum = 0;
        int times = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer value : map.values()) {
            if (value > sum) {
                sum = value;
                times = 1;
            } else if (value == sum) {
                times++;
            }
        }

        return sum * times;
    }
}
