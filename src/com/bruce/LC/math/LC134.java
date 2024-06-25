package com.bruce.LC.math;


public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int result = 0;
        int total = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {

            result += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (result < 0) {
                startIndex = i + 1;
                result = 0;
            }
        }


        return total >= 0 ? startIndex : -1;
    }

    public static void main(String[] args) {
        System.out.println(new LC134().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
