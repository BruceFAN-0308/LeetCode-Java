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

    // 1 means hold, 0 means unHold
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][0] = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
        }

        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        System.out.println(new LC121().maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
