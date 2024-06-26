package com.bruce.LC.matrixLoop;

import com.bruce.LC.util.Utils;

public class LC59 {
    public int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, count = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                results[top][i] = count;
                count++;
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                results[i][right] = count;
                count++;
            }
            right--;
            if (right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                results[bottom][i] = count;
                count++;
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                results[i][left] = count;
                count++;
            }
            left++;
            if (left > right) {
                break;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[][] ints = new LC59().generateMatrix(4);
        Utils.logNumbers(ints);
    }
}
