package com.everyday.leetcode.dynamicProgramming;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-19 21:51
 **/
public class LC70 {

    public int climbStairs(int n) {

        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LC70().climbStairs(2));
    }

}
