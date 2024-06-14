package com.everyday.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-05 13:58
 **/
public class LC1544 {
    public String makeGood(String s) {
        if (s.length() == 1) {
            return s;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                deque.push(c);
                continue;
            }
            Character peek = deque.peek();
            if (Math.abs(c - peek) == 32) {
                deque.pop();
            } else {
                deque.push(c);
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollLast());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String abBAcC = new LC1544().makeGood("leEeetcode");
        System.out.println(abBAcC);
    }
}
