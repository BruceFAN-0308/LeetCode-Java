package com.bruce.LC.dp;

public class LC97 {
    public boolean isInterleaveDP(String s1, String s2, String s3) {

        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int index = i + j - 1;
                if (index < 0) {
                    continue;
                }
                char c = s3.charAt(index);
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == c;
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == c);
                }
            }
        }
        return dp[m];
    }


    public boolean isInterleave1(String s1, String s2, String s3) {

        int n = s1.length(), m = s2.length(), t = s3.length();

        if (m + n != t) {
            return false;
        }


        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int index = i + j - 1;
                if (index < 0) {
                    continue;
                }
                char c = s3.charAt(index);
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == c);
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == c);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new LC97().isInterleaveDP("aabcc", "dbbca", "aadbbcbcac"));
    }
}
