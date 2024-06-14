package com.everyday.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-02-29 18:48
 **/

/*
* A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
* */
public class LC1609 {

    public static void main(String[] args) {


        new LC1609().isEvenOddTree(new TreeNode(1,
                new TreeNode(10,
                        new TreeNode(3,
                                new TreeNode(12,
                                        null, null),
                                new TreeNode(8,
                                        null, null)), null), new TreeNode(4, new TreeNode(7, new TreeNode(6, null, null), null), new TreeNode(9, null, new TreeNode(2, null, null)))
        ));
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    if (node.val % 2 == 0 || node.val <= count) {
                        return false;
                    }
                } else {
                    if (node.val % 2 != 0 || node.val >= count) {
                        return false;
                    }
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                count = node.val;
            }
            flag = !flag;
        }
        return true;
    }

}
