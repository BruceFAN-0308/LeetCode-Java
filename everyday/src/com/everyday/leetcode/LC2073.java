package com.everyday.leetcode;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-09 09:27
 **/
public class LC2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sum = 0;
        if (tickets[k] == 1) {
            return k + 1;
        }
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] != 0) {
                    tickets[i] = tickets[i] - 1;
                    sum++;
                }
                if (i == k && tickets[k] == 0) {
                    return sum;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LC2073().timeRequiredToBuy(new int[]{2, 3, 2}, 2));
    }
}
