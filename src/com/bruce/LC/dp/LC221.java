package com.bruce.LC.dp;

public class LC221 {

    public int maximalSquare(char[][] matrix) {

        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if (i != 0 && j != 0) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    // scrolling
    public int maximalSquareScrolling(char[][] matrix) {

        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int columns = matrix[0].length;
        int[] dp = new int[columns];
        int westNorthern;
        int prev = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    westNorthern = dp[j];
                    if (i != 0 && j != 0) {
                        dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[j] = Math.max(dp[j], 1));
                    prev = westNorthern;
                } else {
                    dp[j] = 0;
                }
            }
        }


        return maxSide * maxSide;
    }

    public static void main(String[] args) {
//        System.out.println(new LC221().maximalSquareScrolling(new char[][]{
//                {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
//                {'0', '0', '1', '1', '1'}
//        }));
//        System.out.println(new LC221().maximalSquareScrolling(new char[][]{
//                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
//        }));
        System.out.println(new LC221().maximalSquareScrolling(new char[][]{
                {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}
        }));
    }
}
