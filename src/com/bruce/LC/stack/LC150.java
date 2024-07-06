package com.bruce.LC.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            Integer first;
            Integer second;
            switch (token) {
                case "+":
                    first = deque.poll();
                    second = deque.poll();
                    deque.push(first + second);
                    break;
                case "-":
                    first = deque.poll();
                    second = deque.poll();
                    deque.push(second - first);
                    break;
                case "*":
                    first = deque.poll();
                    second = deque.poll();
                    deque.push(first * second);
                    break;
                case "/":
                    first = deque.poll();
                    second = deque.poll();
                    deque.push(second / first);
                    break;
                default:
                    deque.push(Integer.valueOf(token));
            }
        }

        return deque.peek();
    }

    public static void main(String[] args) {
        System.out.println(new LC150().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
