package com.bruce.LC.dp;

public class LC123 {

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2 + 2][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= 3; j++) {
                dp[i][j][0] = Integer.MIN_VALUE / 2;
                dp[i][j][1] = Integer.MIN_VALUE / 2;
            }
        }

        for (int i = 1; i <= 3; i++) {
            dp[0][i][0] = 0;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i + 1][j][0] = Math.max(dp[i][j][0], dp[i][j][1] + prices[i]);
                dp[i + 1][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][0] - prices[i]);
            }
        }


        return dp[prices.length][3][0];
    }

    // 0 <= prices[i] <= 10^5
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[2 + 2][2];

        for (int j = 0; j < 2 + 2; j++) {
            dp[j][1] = -100001;
        }
        dp[0][0] = -100001;

        for (int price : prices) {
            for (int i = 1; i < 2 + 2; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + price);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - price);
            }
        }

        return dp[3][0];
    }

    // only twice transaction, so only need four param
    public int maxProfit2(int[] prices) {

        Integer minValue = -100001;
        int firstBuy = minValue;
        int firstSell = 0;
        int secondBuy = minValue;
        int secondSell = 0;
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        return secondSell;
    }

    public static void main(String[] args) {

        System.out.println(new LC123().maxProfit2(new int[]{

                3,3,5,0,0,3,1,4
        }));
    }
}
