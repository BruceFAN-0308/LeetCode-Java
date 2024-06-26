package com.bruce.LC.doublePointer;

public class LC9 {
    // process as a string
    public boolean isPalindrome(int x) {
        char[] charArray = String.valueOf(x).toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // process as a stack

    public static void main(String[] args) {
        new LC9().isPalindrome(121);
    }
}
