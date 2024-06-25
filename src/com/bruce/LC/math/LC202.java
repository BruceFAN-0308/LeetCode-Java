package com.bruce.LC.math;

import java.util.HashSet;

public class LC202 {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        int value = n;


        while (value != 1) {
            int count = 0;
            while (value > 0) {
                int remainder = value % 10;
                count = remainder * remainder + count;
                value = value / 10;
            }
            if (set.contains(count)) {
                break;
            }
            set.add(count);
            value = count;
        }
        return value == 1;
    }

    public static void main(String[] args) {
        System.out.println(new LC202().isHappy(2));
    }
}
