package com.bruce.LC.slideWindows;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LC76 {

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 初始化 need，记录 t 中每个字符的出现次数
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0; // 窗口的左右边界
        int valid = 0; // 已经匹配上的字符数量
        int start = 0, minLen = Integer.MAX_VALUE; // 最小窗口的起始位置和长度

        while (right < s.length()) {
            char r = s.charAt(right);
            right++;

            // 更新窗口内字符的计数
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            // 当窗口内的字符已经完全包含了 t 中的所有字符时
            while (valid == need.size()) {
                // 更新最小窗口的起始位置和长度
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char l = s.charAt(left);
                // 缩小窗口，移动左边界
                if (need.containsKey(l)) {
                    window.put(l, window.get(l) - 1);
                    if (window.get(l) < need.get(l)) valid--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public String windows(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        // 初始化 need，记录 t 中每个字符的出现次数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0, start = 0, length = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (Objects.equals(map.get(c), need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < length) {
                    length = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                if (need.containsKey(l)) {
                    map.put(l, map.get(l) - 1);
                    if (map.get(l) < need.get(l)) {
                        valid--;
                    }
                }
                left++;
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }

    public static void main(String[] args) {
        System.out.println(new LC76().windows("ADOBECODEBANC", "ABC"));
    }
}
