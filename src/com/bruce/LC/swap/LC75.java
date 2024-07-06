package com.bruce.LC.swap;

public class LC75 {
    public void sortColors(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }
        int i = 0;
        while (zero > 0) {
            nums[i] = 0;
            i++;
            zero--;
        }
        while (one > 0) {
            nums[i] = 1;
            i++;
            one--;
        }
        while (two > 0) {
            nums[i] = 2;
            i++;
            two--;
        }
    }

    public void sortColorsBySwap(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i <= right && nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        new LC75().sortColorsBySwap(new int[]{0, 2, 1, 2, 0, 2, 1, 1, 0});
    }
}
