package com.bruce.LC.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC735 {
    public int[] asteroidCollision(int[] asteroids) {


        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            boolean add = true;
            while (!deque.isEmpty() && asteroids[i] * deque.peekLast() < 0 && asteroids[i] < deque.peekLast()) {
                int asteroid = Math.abs(asteroids[i]);
                if (asteroid > deque.peekLast()) {
                    deque.pollLast();
                    continue;
                }
                if (asteroid == deque.peekLast()) {
                    deque.pollLast();
                }
                add = false;
                break;
            }
            if (add) {
                deque.addLast(asteroids[i]);
            }
        }

        int[] results = new int[deque.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = deque.pollFirst();
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i : new LC735().asteroidCollision(new int[]{5, 10, -5})) {
            System.out.println(i + " ");
        }
    }
}
