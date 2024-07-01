package com.bruce.LC.dfs;

import java.util.Arrays;

public class LC322 {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int nowAmount = 1; nowAmount <= amount; nowAmount++) {
            for (int coin : coins) {
                if (coin <= nowAmount) {
                    dp[nowAmount] = Math.min(dp[nowAmount], dp[nowAmount - coin] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(new LC322().coinChange(new int[]{1, 2, 5}, 11));
    }
}
