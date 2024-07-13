package com.bruce.LC.tree;

import com.bruce.LC.util.TreeNode;

public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null; // 1.
        }
        if (left == null) {
            return right; // 3.
        }
        if (right == null) {
            return left; // 4.
        }
        return root; // 2. if(left != null and right != null)

    }

    public static void main(String[] args) {
        new LC236().lowestCommonAncestor(new TreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(new Integer[]{5}), new TreeNode(new Integer[]{1}));
    }


}
