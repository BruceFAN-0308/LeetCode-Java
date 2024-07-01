package com.bruce.LC.daily;

public class LC1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int left = 0, right = 0;
        while (right < arr.length) {
            if (right - left >= 3) {
                return true;
            }
            if (arr[right] % 2 == 0) {
                left = right;
            }
            right++;
        }
        return arr[left] % 2 != 0 && right - left >= 3;
    }

    public static void main(String[] args) {
        System.out.println(new LC1550().threeConsecutiveOdds(new int[]{1, 2, 1, 1}));
    }
}
