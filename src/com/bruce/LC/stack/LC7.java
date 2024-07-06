package com.bruce.LC.stack;

public class LC7 {
    public int reverse(int x) {
        int ans = 0;
        int num = Math.abs(x);
        while (num > 0) {
            int i = num % 10;
            if ((long) ans * 10 + i > Integer.MAX_VALUE) {
                return 0;
            }
            ans = ans * 10 + i;
            num = num / 10;
        }

        return x >= 0 ? ans : -ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC7().reverse(1534236469));
    }
}
