package com.bruce.LC.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC42 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int result = 0;
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int min = Math.min(left[i], right[i]);
            if (min - height[i] > 0) {
                result = result + min - height[i];
            }
        }
        return result;
    }

    // double index
    public int trapByDoubleIndex(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (leftMax < rightMax) {
                result = result + leftMax - height[left];
                left++;
            } else {
                result = result + rightMax - height[right];
                right--;
            }
        }
        return result;
    }

    public int trapByMonotonousStack(int[] height) {
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {

            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                Integer top = deque.pop();
                if (deque.isEmpty()) {
                    break;
                }
                int left = deque.peek();
                int width = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[top];
                result += h * width;
            }
            deque.push(i);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new LC42().trapByMonotonousStack(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
