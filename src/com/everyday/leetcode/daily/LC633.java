package com.everyday.leetcode.daily;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-17 12:00
 **/
public class LC633 {

    public boolean judgeSquareSum(int c) {

        Long right = (long) Math.floor(Math.sqrt(c));
        Long left = 0L;
        while (left <= right) {
            // have to use long type, because there might be overflow
            Long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new LC633().judgeSquareSum(2147483600);
        System.out.print(b);
    }
}
