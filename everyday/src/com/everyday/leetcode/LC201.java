package com.everyday.leetcode;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-02-20 21:22
 **/

/*
* Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
*
Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0


Constraints:

0 <= left <= right <= 231 - 1
* */
public class LC201 {
    public static void main(String[] args) {
        System.out.println(new LC201().rangeBitwiseAnd(5, 7));
    }

    // 寻找最大的数和最小的数的公共前缀
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}
