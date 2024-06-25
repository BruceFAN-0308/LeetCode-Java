package com.bruce.LC.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC456 {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                k = deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(new LC456().find132pattern(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10}));
    }
}
