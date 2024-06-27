package com.bruce.LC.doublePointer;

public class LC5 {
    public String longestPalindrome(String s) {

        int leftIndex = 0;
        int rightIndex = 0;
        int result = 1;


        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left > 0 && s.charAt(left - 1) == s.charAt(left)) {
                left--;
            }
            while (right < s.length() - 1 && s.charAt(right + 1) == s.charAt(right)) {
                right++;
            }
            while (left > 0 && right < s.length() - 1
                    && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            int length = right + 1 - left;
            if (length > result) {
                result = length;
                leftIndex = left;
                rightIndex = right;
            }

        }


        return result == 1 ? s.substring(0, 1) : s.substring(leftIndex, rightIndex + 1);
    }


    public String longestPalindromeDp(String s) {
        int len = s.length();
        int left = 0, right = 0, res = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i <= 1) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i > res) {
                        res = j - i;
                        left = i;
                        right = j;
                    }
                }

            }
        }
        return s.substring(left, right + 1);
    }


    public static void main(String[] args) {
        System.out.println(new LC5().longestPalindrome("babad"));
    }
}
