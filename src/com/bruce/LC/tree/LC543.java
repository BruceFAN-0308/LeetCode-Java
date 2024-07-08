package com.bruce.LC.tree;

import com.bruce.LC.util.TreeNode;

public class LC543 {

    int length = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return length;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);
        this.length = Math.max(length, leftLength + rightLength);
        return Math.max(leftLength, rightLength) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LC543().diameterOfBinaryTree(new TreeNode(new Integer[]{1, 2, 3, 4, 5})));
    }
}
