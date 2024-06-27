package com.bruce.LC.map;

import java.util.*;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        new LC49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
