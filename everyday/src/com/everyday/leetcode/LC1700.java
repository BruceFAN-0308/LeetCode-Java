package com.everyday.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-08 16:54
 **/
public class LC1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int s0 = 0, s1 = 0;
        for (int student : students) {
            if (student == 1) {
                s1++;
            } else {
                s0++;
            }
        }

        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

    public static void main(String[] args) {
        System.out.println(new LC1700().countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}
