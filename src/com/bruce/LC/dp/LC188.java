package com.bruce.LC.dp;

public class LC188 {
    public int maxProfit(int k, int[] prices) {

        int length = prices.length;
        int[][][] dp = new int[length + 1][k + 2][2];

        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < k + 2; j++) {
                dp[i][j][0] = Integer.MIN_VALUE + 1001;
                dp[i][j][1] = Integer.MIN_VALUE + 1001;
            }
        }

        for (int i = 1; i < k + 2; i++) {
            dp[0][i][0] = 0;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= k + 1; j++) {
                dp[i + 1][j][0] = Math.max(dp[i][j][0], dp[i][j][1] + prices[i]);
                dp[i + 1][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][0] - prices[i]);
            }
        }

        return dp[length][k + 1][0];

    }

    public int maxProfit1(int k, int[] prices) {

        int length = prices.length;
//        int[][][] dp = new int[length + 1][k + 2][2];
        int[][] dp = new int[k + 2][2];

        for (int i = 0; i < k + 2; i++) {
            dp[i][1] = Integer.MIN_VALUE + 1001;
        }
        dp[0][0] = Integer.MIN_VALUE + 1001;

        for (int price : prices) {
            for (int i = 1; i < k + 2; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + price);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - price);
            }
        }

        return dp[k + 1][0];

    }

    public static void main(String[] args) {
        System.out.println(new LC188().maxProfit1(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
