package com.everyday.leetcode;

import java.util.*;

/**
 * @description: fdsa
 * @author: Luoxin Fan
 * @create: 2024-06-16 13:51
 **/
public class LC522 {
    public int findLUSlength(String[] strs) {

        List<String> strings = Arrays.asList(strs);
        strings.sort((o1, o2) -> o2.length() - o1.length());

        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if (map.containsKey(string)) {
                map.put(string, -1);
            } else {
                map.put(string, string.length());
            }
        }

        for (String string : strings) {
            if (map.get(string) == -1) {
                continue;
            }
            boolean isSubString = false;
            for (String key : strings) {
                if (!Objects.equals(key, string) && key.length() > string.length() && isSubString(key, string)) {
                    isSubString = true;
                    break;
                }
            }
            if (!isSubString) {
                return string.length();
            }
        }

        return -1;
    }

    public boolean isSubString(String original, String target) {
        int i = 0, j = 0;
        while (i < original.length() && j < target.length()) {
            if (original.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == target.length();
    }

    public static void main(String[] args) {
        String[] params = {"abaa", "abaa", "eaec", "eaec", "eae", "z"};
        System.out.println(new LC522().findLUSlength(params));
    }
}
