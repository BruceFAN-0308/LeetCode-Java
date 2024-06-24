package com.bruce.LC.preSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 4) {
            return lists;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                while (j > i + 1 && j < nums.length && nums[j] == nums[j - 1]) {
                    j++;
                }
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    long temp = (long) nums[start] + nums[end] + nums[i] + nums[j];
                    if (temp == target) {
                        lists.add(Arrays.asList(nums[start], nums[end], nums[i], nums[j]));
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;
                        end--;
                    } else if (temp > target) {
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    } else {
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;
                    }
                }

            }
        }


        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new LC18().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}
