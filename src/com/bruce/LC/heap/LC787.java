package com.bruce.LC.heap;

import java.util.Arrays;

public class LC787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = new int[n];
            Arrays.fill(temp, INF);
            temp[src] = 0;
            for (int[] flight : flights) {
                int source = flight[0], target = flight[1], cost = flight[2];
                temp[target] = Math.min(temp[target], dp[source] + cost);
            }
            dp = temp;
        }
        return dp[dst] == INF ? -1 : dp[dst];

    }


    public static void main(String[] args) {
        System.out.println(new LC787().findCheapestPrice(4, new int[][]{
                {0, 1, 100}, {1, 2, 100}, {0, 2, 70}, {1, 3, 600}, {2, 3, 200}
        }, 0, 3, 1));
    }
}
