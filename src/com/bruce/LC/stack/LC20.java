package com.bruce.LC.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class LC20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character peek = deque.peek();
            if (Objects.equals(')', c)) {
                if (peek == null || !Objects.equals('(', peek)) {
                    return false;
                }
                deque.poll();
            } else if (Objects.equals(']', c)) {
                if (peek == null || !Objects.equals('[', peek)) {
                    return false;
                }
                deque.poll();
            } else if (Objects.equals('}', c)) {
                if (peek == null || !Objects.equals('{', peek)) {
                    return false;
                }
                deque.poll();
            } else {
                deque.push(c);
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new LC20().isValid("()[]{}"));
    }
}
