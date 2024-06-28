package com.bruce.LC.heap;

public class LC215 {
    public int findKthLargest(int[] _nums, int k) {
        int length = _nums.length;
        for (int index = length / 2 - 1; index >= 0; index--) {
            siftDown(_nums, index, length);
        }

        for (int i = 0; i < k; i++) {
            swap(_nums, 0, _nums.length - i - 1);
            siftDown(_nums, 0, _nums.length - i - 1);
        }

        return _nums[_nums.length - k];
    }

    private void siftDown(int[] nums, int index, int range) {
        int leftChild = 2 * index + 1;
        while (leftChild < range) {
            int rightChild = leftChild + 1;
            int maxIndex = leftChild;
            if (rightChild < range && nums[leftChild] < nums[rightChild]) {
                maxIndex = rightChild;
            }
            if (nums[maxIndex] < nums[index]) {
                break;
            }
            swap(nums, maxIndex, index);
            index = maxIndex;
            leftChild = 2 * index + 1;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new LC215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
