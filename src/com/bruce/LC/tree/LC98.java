package com.bruce.LC.tree;

import com.bruce.LC.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }
        boolean left = dfs(node.left, min, node.val);
        boolean right = dfs(node.right, node.val, max);
        return left && right;
    }

    public boolean isValidBSTByTravel(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        long value = Long.MIN_VALUE;
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.poll();
            if (root.val <= value) {
                return false;
            }
            value = root.val;
            root = root.right;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new LC98().isValidBSTByTravel(new TreeNode(new Integer[]{5, 4, 6, null, null, 3, 7})));
    }

}
