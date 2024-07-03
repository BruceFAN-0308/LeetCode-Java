package com.bruce.LC.binarySearch;

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        for (int[] nums : matrix) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public boolean searchMatrixByZSearch(int[][] matrix, int target) {

        int row = 0, column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LC240().searchMatrixByZSearch(new int[][]{
                {-1, 3}
        }, 3));

    }
}
