package com.bruce.LC.math;

public class LC238 {

    /*
     * can not use Array.sum() and division every single number, because once the nums[n] = 0, the result will be wrong
     * */
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public static void main(String[] args) {
        for (int i : new LC238().productExceptSelf(new int[]{1, 2, 3, 4})) {
            System.out.println(i + " ");
        }
    }
}
