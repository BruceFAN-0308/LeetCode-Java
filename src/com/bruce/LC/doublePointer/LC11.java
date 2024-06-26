package com.bruce.LC.doublePointer;


public class LC11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currentArea, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new LC11().maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }
}
