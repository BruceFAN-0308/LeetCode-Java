package com.everyday.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-02 16:57
 **/
public class LC205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] nums = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                nums[i] = map.get(chars[i]);
            } else {
                map.put(chars[i], count);
                nums[i] = count;
                count++;
            }
        }
        char[] charArray = t.toCharArray();
        map.clear();
        count = 0;
        for (int i = 0; i < charArray.length; i++) {
            int value = 0;
            if (map.containsKey(charArray[i])) {
                value = map.get(charArray[i]);
            } else {
                map.put(charArray[i], count);
                value = count;
                count++;
            }
            if (value != nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LC205().isIsomorphic("egg", "add"));
    }
}
