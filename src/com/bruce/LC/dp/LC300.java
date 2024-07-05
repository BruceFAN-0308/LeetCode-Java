package com.bruce.LC.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i : dp) {
            max = Math.max(max, i);
        }

        return max;
    }

    public int lengthOfLISBinary(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int size = 0;
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Integer lastValue = list.get(list.size() - 1);
            if (nums[i] > lastValue) {
                list.add(nums[i]);
            } else if (nums[i] < lastValue && !list.contains(nums[i])) {
                int index = Collections.binarySearch(list, nums[i]);
                if (index >= 0) {
                    continue;
                }
                index = -index;
                size = Math.max(size, list.size());
                int k = list.size() - index + 1;
                for (int j = 0; j < k; j++) {
                    list.remove(list.size() - 1);
                }
                list.add(nums[i]);
            }
        }
        return Math.max(size, list.size());
    }

    public int lengthOfLISBinary1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = Collections.binarySearch(list, nums[i]);
            if (index >= 0) {
                continue;
            }
            index = -index - 1;
            if (index == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println(new LC300().lengthOfLISBinary1(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
