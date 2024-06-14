package com.everyday.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-11 11:35
 **/
public class LC791 {

    public static void main(String[] args) {
        System.out.println(new LC791().customSortString("bcafg", "abcd"));
    }

    public String customSortString(String order, String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder builder = new StringBuilder();
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                for (Integer integer = 0; integer < map.get(chars[i]); integer++) {
                    builder.append(chars[i]);
                }
                map.remove(chars[i]);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (Integer i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
        }

        return builder.toString();

    }

}
