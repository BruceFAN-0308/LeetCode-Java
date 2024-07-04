package com.bruce.LC.dp;

public class LC45 {
    public int jump(int[] nums) {

        int ans = 0;
        int right = 0;
        int max = 0;
        // if I am in last step, I do not need to jump again, so the loop is [0, nums.length - 1]
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == right) {
                right = max;
                ans++;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new LC45().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
