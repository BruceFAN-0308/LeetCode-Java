package com.bruce.LC.daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1598 {
    public int minOperations(String[] logs) {
        Deque<String> deque = new ArrayDeque<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else if (!log.equals("./")) {
                deque.push(log);
            }
        }

        return deque.size();
    }

    public static void main(String[] args) {
        System.out.println(new LC1598().minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }
}
