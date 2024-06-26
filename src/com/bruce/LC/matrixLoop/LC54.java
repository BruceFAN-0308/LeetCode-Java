package com.bruce.LC.matrixLoop;

import com.bruce.LC.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            t++;
            if (t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            if (r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                list.add(matrix[b][i]);
            }
            b--;
            if (b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {
                list.add(matrix[i][l]);
            }
            l++;
            if (l > r) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] ints = {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };
        Utils.logNumbers(ints);
        System.out.println(new LC54().spiralOrder(ints));
    }
}
