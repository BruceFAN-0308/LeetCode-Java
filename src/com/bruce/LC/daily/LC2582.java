package com.bruce.LC.daily;

public class LC2582 {
    public int passThePillow(int n, int time) {
        if (n > time) {
            return time + 1;
        }
        int res = time / (n - 1);
        int ans = time % (n - 1);

        return res % 2 == 0 ? ans + 1 : n - ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC2582().passThePillow(8, 9));
    }
}
