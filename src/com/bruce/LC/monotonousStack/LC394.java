package com.bruce.LC.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class LC394 {
    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();
        Deque<Object> deque = new ArrayDeque<>();

        StringBuilder number = new StringBuilder();

        for (char c :charArray){
            if (Character.isDigit(c)) {
                number.append(c);
                continue;
            }
            if (!number.isEmpty()) {
                deque.addLast(number);
                number = new StringBuilder();
            }

            if (Objects.equals(']', c)) {
                StringBuilder current = new StringBuilder();
                while (!deque.isEmpty() && !Objects.equals("[", deque.peekLast())) {
                    current.insert(0,deque.pollLast());
                }
                deque.pollLast();

                Object count = deque.pollLast();
                StringBuilder result = new StringBuilder();
                for (Integer integer = 0; integer < Integer.valueOf(String.valueOf(count)); integer++) {
                    result.append(current);
                }

                deque.addLast(result.toString());
            } else {
                deque.addLast(String.valueOf(c));
            }
        }

        for (Object o : deque) {
            stringBuilder.append(o);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LC394().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
