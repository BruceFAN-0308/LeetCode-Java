package com.everyday.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-04 10:26
 **/
public class LC1614 {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Objects.equals(c, '(')) {
                count++;
                max = Math.max(max, count);
            } else if (Objects.equals(c, ')')) {
                count--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LC1614().maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
