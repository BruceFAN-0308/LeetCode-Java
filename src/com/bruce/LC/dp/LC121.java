package com.bruce.LC.dp;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 17:04
 **/
public class LC121 {
    public int maxProfit(int[] prices) {

        int maxValue = 0;
        int soFarMinIndex = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[soFarMinIndex]) {
                soFarMinIndex = i;
            } else {
                maxValue = Math.max(maxValue, prices[i] - prices[soFarMinIndex]);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(new LC121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
