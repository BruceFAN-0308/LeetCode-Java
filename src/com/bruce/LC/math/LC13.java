package com.bruce.LC.math;

import java.util.*;

public class LC13 {
    public int romanToInt(String s) {
        int sum = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (map.get(chars[i]) < map.get(chars[i - 1])) {
                list.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(chars[i]);
        }
        if (stringBuilder.isEmpty()) {
            list.add(stringBuilder.toString());
        }
        for (String string : list) {
            char[] charArray = string.toCharArray();

            int count = 0;
            for (int i = charArray.length - 1; i >= 0; i--) {
                if (i == charArray.length - 1) {
                    count += map.get(charArray[i]);
                } else if (i >= 1 && charArray[i] == charArray[i - 1]) {
                    count += map.get(charArray[i]);
                } else if (i == 0 && charArray[i] == charArray[i + 1]) {
                    count += map.get(charArray[i]);
                } else {
                    count = count - map.get(charArray[i]);
                }
            }
            sum += count;
        }


        return sum;

    }


    public int romanToIntByMath(String s) {
        int ans = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC13().romanToIntByMath("MCMXCIV"));
    }
}
