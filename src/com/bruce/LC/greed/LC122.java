package com.bruce.LC.greed;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 17:15
 **/
public class LC122 {
    public int maxProfit(int[] prices) {
        int total = 0;


        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }

        return total;

    }

    public static void main(String[] args) {
        System.out.println(new LC122().maxProfit(new int[]{2, 1, 2, 0, 1}));
    }
}
