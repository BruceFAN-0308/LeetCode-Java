package com.bruce.LC.dp;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 17:15
 **/
public class LC122 {

    // 1 means hold, 0 means unHold
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length + 1][2];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][0] = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[prices.length][0];

    }

    public int maxProfit1(int[] prices) {

        int unHold = 0;
        int hold = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = hold;
            hold = Math.max(hold, unHold - price);
            unHold = Math.max(unHold, temp + price);
        }

        return unHold;
    }


    public static void main(String[] args) {
        System.out.println(new LC122().maxProfit1(new int[]{2, 1, 2, 0, 1}));
    }
}
