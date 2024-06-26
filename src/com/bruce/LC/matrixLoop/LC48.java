package com.bruce.LC.matrixLoop;

import com.bruce.LC.util.Utils;

public class LC48 {
    public void rotate(int[][] matrix) {
        int[][] results = new int[matrix.length][matrix[0].length];

        // matrix[i][j] = matrix[j][martix.length-1-i]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                results[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results.length; j++) {
                matrix[i][j] = results[i][j];
            }
        }

    }

    public void rotateBySelf(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }

        Utils.logNumbers(matrix);

    }

    public static void main(String[] args) {
        new LC48().rotateBySelf(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        });
    }
}
