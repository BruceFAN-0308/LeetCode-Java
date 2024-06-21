package com.everyday.leetcode.binarySearch;

import java.util.Stack;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-18 22:31
 **/
public class LC744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int binary = (start + end) / 2;
            if (letters[binary] > target) {
                end = binary - 1;
            } else {
                start = binary + 1;
            }
        }

        return start < letters.length ? letters[start] : letters[0];
    }

    public static void main(String[] args) {
        System.out.println(new LC744().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }
}
