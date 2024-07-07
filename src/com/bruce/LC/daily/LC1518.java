package com.bruce.LC.daily;

public class LC1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int extra = numBottles;
        while (extra >= numExchange) {
            int i = extra % numExchange;
            int j = extra / numExchange;
            extra = i + j;
            ans += j;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC1518().numWaterBottles(15, 4));
    }
}
