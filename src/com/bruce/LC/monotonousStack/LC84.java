package com.bruce.LC.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC84 {
    public int largestRectangleArea(int[] heights) {
        //单调栈 遍历原数组，枚举每个元素，
        //元素比栈顶元素大，加入栈中；
        //元素比栈顶元素小，栈顶元素出栈，计算以栈顶元素为高度的矩形面积

        Deque<Integer> stack = new ArrayDeque<>();//为方便计算矩形长度，存放的是元素下标
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {//当前元素小于栈顶元素
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;//i和stack.peek()为stack.pop()元素的左右两个小于元素
                res = Math.max(res, height * width);
            }
            stack.push(i);
        }

        //处理栈中剩余元素 [1,2,3]
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            res = Math.max(res, height * width);
        }


        return res;

    }

    public int largestRectangleAreaByMonotonousStack(int[] heights) {
        int result = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (deque.peek() != -1 && heights[deque.peek()] >= heights[i]) {
                Integer heightIndex = deque.pop();
                int width = i - deque.peek() - 1;
                int height = heights[heightIndex];
                result = Math.max(result, width * height);
            }
            deque.push(i);
        }

        while (deque.peek() != -1) {
            Integer heightIndex = deque.pop();
            int width = heights.length - deque.peek() - 1;
            int height = heights[heightIndex];
            result = Math.max(result, width * height);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new LC84().largestRectangleAreaByMonotonousStack(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
