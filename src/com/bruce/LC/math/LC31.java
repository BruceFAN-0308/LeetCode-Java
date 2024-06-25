package com.bruce.LC.math;

public class LC31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int start = nums.length - 2;
        while (start >= 0 && nums[start + 1] <= nums[start]) {
            start--;
        }
        if (start < 0) {
            reverse(nums, 0);
            return;
        }

        int temp = start + 1;
        while (temp < nums.length && nums[temp] > nums[start]) {
            temp++;
        }
        temp--;
        swap(nums, start, temp);
        reverse(nums, start + 1);

    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    // the right of start array is decrease order, so just reverse, do not need to order again
    private void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        new LC31().nextPermutation(new int[]{4, 5, 2, 6, 3, 1});
    }
}
