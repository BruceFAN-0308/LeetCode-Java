package com.bruce.LC.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int count = 1;
            int k = i + 1;
            while (set.contains(k)) {
                count++;
                k++;
            }
            max = Math.max(max, count);

        }
        return max;
    }

    public int longestConsecutiveDP(int[] nums) {
        // key表示num，value表示num所在连续区间的长度
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            // 当map中不包含num，也就是num第一次出现
            if (!map.containsKey(num)) {
                // left为num-1所在连续区间的长度，更进一步理解为：左连续区间的长度
                int left = map.getOrDefault(num - 1, 0);
                // right为num+1所在连续区间的长度，更进一步理解为：右连续区间的长度
                int right = map.getOrDefault(num + 1, 0);
                // 当前连续区间的总长度
                int curLen = left + right + 1;
                ans = Math.max(ans, curLen);
                // 将num加入map中，表示已经遍历过该值。其对应的value可以为任意值。
                map.put(num, -1);
                // 更新当前连续区间左边界和右边界对应的区间长度
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC128().longestConsecutiveDP(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
