package com.everyday.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 12:44
 **/
public class LC455 {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;

        int gIndex = 0;
        int sIndex = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
                result++;
            }
            sIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC455().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
