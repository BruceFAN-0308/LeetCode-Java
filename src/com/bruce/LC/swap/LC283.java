package com.bruce.LC.swap;

public class LC283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int k = 0;
        for (; left < nums.length; k++, left++) {
            while (left < nums.length && nums[left] == 0) {
                left++;
            }
            if (left >= nums.length) {
                break;
            }
            nums[k] = nums[left];
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
            i++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        new LC283().moveZeroes1(new int[]{0, 1, 0, 3, 12});
    }
}
