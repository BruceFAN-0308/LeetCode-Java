package com.bruce.LC.stack;

import java.util.*;

public class LC224 {
    public int calculate(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        Long ans = 0L;
        int sign = 1;
        deque.push(sign);

        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case ' ':
                    break;
                case '+':
                    sign = deque.peek();
                    break;
                case '-':
                    sign = -deque.peek();
                    break;
                case '(':
                    deque.push(sign);
                    break;
                case ')':
                    deque.pop();
                    break;
                default:
                    long num = 0;
                    while (Character.isDigit(c)) {
                        num = num * 10 + c - '0';
                        i++;
                        if (i >= length) {
                            break;
                        }
                        c = s.charAt(i);
                    }
                    ans = ans + sign * num;
                    i--;
            }
        }

        return ans.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new LC224().calculate("1 + 1"));

//        System.out.println(new LC224().getIntValue(Arrays.asList("1", "2", "3")));


    }
}
