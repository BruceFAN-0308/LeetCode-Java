package com.everyday.leetcode.daily;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-15 17:10
 **/
public class LC521 {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        new LC521().findLUSlength("aba", "cbc");
    }
}
