package com.bruce.LC.preSum;

import java.util.*;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = 0 - nums[j] - nums[i];
                if (map.containsKey(temp) && map.get(temp) > j) {
                    lists.add(Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j]));
                }
                // last put will cover the first put, so if there are same values. entry.value() is always the last index.
                j = map.get(nums[j]);
            }
            i = map.get(nums[i]);
        }

        return lists;
    }

    public List<List<Integer>> threeSumDoubleIndex(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int startIndex = i + 1;
            int endIndex = nums.length - 1;
            while (startIndex < endIndex) {
                if (nums[startIndex] + nums[endIndex] + nums[i] == 0) {
                    lists.add(Arrays.asList(nums[startIndex], nums[endIndex], 0 - nums[startIndex] - nums[endIndex]));
                    while (startIndex < nums.length - 1 && nums[startIndex] == nums[startIndex + 1]) {
                        startIndex++;
                    }
                    while (endIndex > 0 && nums[endIndex] == nums[endIndex - 1]) {
                        endIndex--;
                    }

                    startIndex++;
                    endIndex--;

                } else if (nums[startIndex] + nums[endIndex] + nums[i] > 0) {
                    endIndex--;
                } else {
                    startIndex++;
                }
            }

        }

        return lists;
    }

    public static void main(String[] args) {
        for (List<Integer> integers : new LC15().threeSumDoubleIndex(new int[]{1, -1, -1, 0})) {
            for (Integer integer : integers) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }
    }
}
