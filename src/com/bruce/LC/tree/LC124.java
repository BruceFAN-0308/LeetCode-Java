package com.bruce.LC.tree;

import com.bruce.LC.util.TreeNode;

public class LC124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = Math.max(0, maxGain(root.left));
        int rightValue = Math.max(0, maxGain(root.right));
        int gain = leftValue + rightValue + root.val;
        maxSum = Math.max(maxSum, gain);
        return root.val + Math.max(leftValue, rightValue);
    }

    public static void main(String[] args) {
        System.out.println(new LC124().maxPathSum(new TreeNode(new Integer[]{1, 2, 3})));
    }
}
