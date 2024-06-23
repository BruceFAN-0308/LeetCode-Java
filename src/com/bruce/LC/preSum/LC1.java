package com.bruce.LC.preSum;

import java.util.HashMap;
import java.util.Objects;

public class LC1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && !Objects.equals(map.get(target - nums[i]), i)) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{0, 0};

    }

    public static void main(String[] args) {
        for (int i : new LC1().twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(i);
        }
    }
}
