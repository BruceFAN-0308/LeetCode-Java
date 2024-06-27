package com.bruce.LC.slideWindows;

import java.util.HashMap;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(new LC3().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new LC3().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new LC3().lengthOfLongestSubstring("dvdf"));
    }
}
