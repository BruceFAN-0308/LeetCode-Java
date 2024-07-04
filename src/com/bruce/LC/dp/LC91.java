package com.bruce.LC.dp;

public class LC91 {

    // easy to understand
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[s.length() + 1];
        s = " " + s;
        dp[0] = 1;
        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            int a = charArray[i] - '0';
            int b = charArray[i - 1] * 10 + charArray[i] - '0' * 11;
            if (a >= 1 && a <= 9) {
                dp[i] = dp[i - 1];
            }
            if (b >= 10 && b <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }


        return dp[n];

    }


    // best solution
    public int numDecodingsBest(String s) {
        int n = s.length();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            int b = s.charAt(i - 1) * 10 + s.charAt(i) - '0' * 11;
            if (a >= 1 && a <= 9) {
                dp[i + 1] = dp[i];
            }
            if (b >= 10 && b <= 26) {
                dp[i + 1] = dp[i + 1] + dp[i - 1];
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(new LC91().numDecodings("12"));
    }
}
