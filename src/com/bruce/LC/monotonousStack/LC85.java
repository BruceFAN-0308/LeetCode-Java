package com.bruce.LC.monotonousStack;

import java.util.ArrayDeque;

public class LC85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(calculateMaxArea(heights), maxArea);
        }
        return maxArea;
    }

    public int calculateMaxArea(int[] heights) {
        int result = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (deque.peek() != -1 && heights[deque.peek()] >= heights[i]) {
                Integer top = deque.pop();
                int height = heights[top];
                int width = i - deque.peek() - 1;
                result = Math.max(width * height, result);
            }
            deque.push(i);
        }

        while (deque.peek() != -1) {
            Integer top = deque.pop();
            int height = heights[top];
            int width = heights.length - deque.peek() - 1;
            result = Math.max(height * width, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC85().maximalRectangle(
                new char[][]{
                        {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
                }
        ));
    }
}
