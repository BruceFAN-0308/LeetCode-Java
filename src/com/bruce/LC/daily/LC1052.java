package com.bruce.LC.daily;

import java.util.Arrays;

public class LC1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        if (customers.length <= minutes) {
            return Arrays.stream(customers).sum();
        }

        int sum = 0;

        int index = 0;
        int maxDecrease = 0;
        for (int i = 0; i < customers.length - minutes + 1; i++) {
            int currentDecrease = 0;
            for (int j = i; j < i + minutes; j++) {
                if (grumpy[j] == 1) {
                    currentDecrease += customers[j];
                }
            }
            if (maxDecrease < currentDecrease) {
                maxDecrease = currentDecrease;
                index = i;
            }
        }
        for (int i = index; i < index + minutes; i++) {
            grumpy[i] = 0;
        }
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LC1052().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{1, 0, 1, 0, 1, 0, 1, 0}, 3));
    }
}
