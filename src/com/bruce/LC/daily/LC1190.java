package com.bruce.LC.daily;

import java.util.*;

public class LC1190 {
    public String reverseParentheses(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (Objects.equals(c, '(')) {
                deque.push('(');
            } else if (Objects.equals(c, ')')) {
                ArrayList<Character> list = new ArrayList<>();
                while (!deque.isEmpty()) {
                    Character poll = deque.poll();
                    if (Objects.equals(poll, '(')) {
                        break;
                    }
                    list.add(poll);
                }
                for (Character item : list) {
                    deque.push(item);
                }
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
        System.out.println(new LC1190().reverseParentheses("(ed(et(oc))el)"));
    }
}
