package com.everyday.leetcode.daily;

import java.util.*;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-11 11:40
 **/
public class LC402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            Integer value = Integer.valueOf(String.valueOf(c));
            if (stack.isEmpty()) {
                stack.add(value);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > value && k > 0) {
                stack.pop();
                k--;
            }
            stack.add(value);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : stack) {
            if (integer == 0 && stringBuilder.length() == 0) {
                continue;
            }
            stringBuilder.append(integer);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LC402().removeKdigits("1234567890", 9));
    }
}
