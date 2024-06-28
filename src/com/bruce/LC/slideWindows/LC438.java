package com.bruce.LC.slideWindows;

import java.util.*;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] charArray = p.toCharArray();
        Arrays.sort(charArray);
        ArrayList<Integer> list = new ArrayList<>();
        Map<Character, Integer> original = new HashMap<>();
        for (char c : p.toCharArray()) {
            original.put(c, original.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (!original.containsKey(c)) {
                left = right;
            }
            if (right - left == p.length()) {
                boolean result = true;

                String temp = s.substring(left, right);
                Map<Character, Integer> map = new HashMap<>();
                for (int i = 0; i < temp.length(); i++) {
                    map.put(temp.charAt(i), map.getOrDefault(temp.charAt(i), 0) + 1);
                }
                if (map.size() != original.size()) {
                    result = false;
                }
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (!Objects.equals(original.get(entry.getKey()), entry.getValue())) {
                        result = false;
                        break;
                    }
                }

                if (result) {
                    list.add(left);
                }
                left++;
            }
        }

        return list;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            if (Arrays.equals(pCount, sCount)) {
                ans.add(i);
            }
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + p.length()) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(s.length() - p.length());
        }

        return ans;

    }

    public static void main(String[] args) {
        for (Integer anagram : new LC438().findAnagrams1("cbaebabacd", "abc")) {
            System.out.println(anagram);
        }

    }
}
