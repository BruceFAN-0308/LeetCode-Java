package com.bruce.LC.stack;

import java.util.ArrayDeque;
import java.util.Objects;

public class LC227 {
    public int calculate(String s) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int length = s.length();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if ((!Objects.equals(' ', c) && !Character.isDigit(c)) || i == length - 1) {
                switch (preSign) {
                    case '+':
                        deque.push(num);
                        break;
                    case '-':
                        deque.push(-num);
                        break;
                    case '*':
                        deque.push(deque.poll() * num);
                        break;
                    default:
                        deque.push(deque.poll() / num);
                }
                preSign = c;
                num = 0;
            }

        }

        int ans = 0;
        for (Integer i : deque) {
            ans += i;
        }

        return ans;
    }

    public static void main(String[] args) {
        int calculate = new LC227().calculate(" 3/2 ");
        System.out.println(calculate);
    }
}
