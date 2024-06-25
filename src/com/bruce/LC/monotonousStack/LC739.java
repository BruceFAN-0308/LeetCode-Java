package com.bruce.LC.monotonousStack;

import java.util.ArrayDeque;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]) {
                Integer pool = deque.pollLast();
                result[pool] = i - pool;
            }
            deque.addLast(i);
        }
        return result;

    }

    public int[] dailyTemperaturesByDP(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < temperatures.length && temperatures[i] >= temperatures[j] && result[j] != 0) {
                j += result[j];
            }
            if (j < temperatures.length && temperatures[i] < temperatures[j]) {
                result[i] = j - i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : new LC739().dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})) {
            System.out.println(i + " ");
        }
    }
}
