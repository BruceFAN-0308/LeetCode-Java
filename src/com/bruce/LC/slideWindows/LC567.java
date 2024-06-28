package com.bruce.LC.slideWindows;

import java.util.Arrays;

public class LC567 {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            s2Count[s2.charAt(s2.length() - i - 1) - 'a']++;
        }

        for (int i = s2.length() - 1; i >= s1.length(); i--) {
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            s2Count[s2.charAt(i) - 'a']--;
            s2Count[s2.charAt(i - s1.length()) - 'a']++;
        }

        return Arrays.equals(s1Count, s2Count);

    }

    public static void main(String[] args) {
        System.out.println(new LC567().checkInclusion("ab", "ab"));
    }
}
