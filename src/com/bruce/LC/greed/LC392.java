package com.bruce.LC.greed;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 21:13
 **/
public class LC392 {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new LC392().isSubsequence("abc", "ahbgdc"));
    }
}
