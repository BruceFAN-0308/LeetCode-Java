package com.bruce.LC.daily;

public class LC1701 {
    public double averageWaitingTime(int[][] customers) {
        double ans = 0d;
        int nowTime = 0;

        for (int[] customer : customers) {
            if (nowTime < customer[0]) {
                nowTime = customer[0];
                ans += customer[1];
            } else {
                ans += customer[1] + (nowTime - customer[0]);
            }
            nowTime += customer[1];
        }

        return ans / customers.length;
    }

    public static void main(String[] args) {
        System.out.println(new LC1701().averageWaitingTime(new int[][]{
                {2, 3}, {6, 3}, {7, 5}, {11, 3}, {15, 2}, {18, 1}
        }));
    }
}
