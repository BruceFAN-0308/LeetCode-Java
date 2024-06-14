package com.everyday.leetcode;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-13 13:43
 **/

/*
*
* Given a positive integer n, find the pivot integer x such that:

The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.



Example 1:

Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 is the pivot integer since: 1 = 1.
Example 3:

Input: n = 4
Output: -1
Explanation: It can be proved that no such integer exist.
* */
public class LC2485 {

    public static void main(String[] args) {
        int i = new LC2485().pivotInteger(15);
        System.out.println(i);
    }

    public int pivotInteger(int n) {

        if (n == 1) {
            return 1;
        }

        int leftSum = 1;
        int rightSum = n;

        int left = 1;
        int right = n;

        while (left <= right) {
            if (leftSum < rightSum) {
                left++;
                leftSum += left;
            }
            if (leftSum > rightSum) {
                right--;
                rightSum += right;
            }
            if (leftSum == rightSum) {
                if (left == right) {
                    return left;
                } else {
                    left++;
                    leftSum += left;
                    right--;
                    rightSum += right;
                }
            }
        }
        return -1;

    }

}
