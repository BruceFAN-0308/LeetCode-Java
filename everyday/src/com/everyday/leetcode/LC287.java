package com.everyday.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-24 16:17
 **/
public class LC287 {

    public static void main(String[] args) {
        System.out.println(new LC287().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        Set<Object> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

}
