package com.bruce.LC.matrixLoop;

import com.bruce.LC.util.Utils;

public class LC498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;
        int[] nums = new int[m * n];
        int k = 0;
        int i = 0;
        while (i < m + n - 1) {

            // for odd number
            int x1 = i < m ? i : m - 1;
            int y1 = i - x1;
            while (x1 >= 0 && y1 < n) {
                nums[k] = mat[x1][y1];
                x1--;
                y1++;
                k++;
            }
            i++;
            if (i >= m + n - 1) {
                break;
            }

            // for even number
            int y2 = i < n ? i : n - 1;
            int x2 = i - y2;
            while (y2 >= 0 && x2 < m) {
                nums[k] = mat[x2][y2];
                y2--;
                x2++;
                k++;
            }
            i++;

        }

        return nums;
    }


    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        Utils.logNumbers(ints);
        for (int i : new LC498().findDiagonalOrder(ints)) {
            System.out.print(i + " ");
        }
    }
}
