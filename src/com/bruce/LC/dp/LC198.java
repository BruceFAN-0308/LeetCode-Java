package com.bruce.LC.dp;


/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-20 11:14
 **/
public class LC198 {
    public int rob(int[] nums) {

        int first = 0;
        int second = 0;


        for (int num : nums) {
            int current = Math.max(first + num, second);
            first = second;
            second = current;
        }

        return second;


    }

    public static void main(String[] args) {
        System.out.println(new LC198().rob(new int[]{1, 2, 3, 1}));
    }
}
