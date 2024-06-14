package com.everyday.leetcode;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-02-19 13:16
 **/

/*
* Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false

Constraints:
-231 <= n <= 231 - 1
* */
public class LC231 {
    public static void main(String[] args) {
        System.out.println(new LC231().isPowerOfTwo(14));
    }

    /*
    * traverse '2 to the 1' to '2 to the 32'
    * if bigger return false
    * if smaller continue
    * if equals return true
    * */
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            double sum = Math.pow(2d, i);
            if (sum == n) {
                return true;
            } else if (sum > n) {
                return false;
            }
        }
        return false;
    }
}
