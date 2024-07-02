package com.bruce.LC.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC863 {
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        dfs(target, null, 0, k);
        return ans;
    }

    private void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    private void dfs(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
        }
        if (node.left != from) {
            dfs(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            dfs(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            dfs(parents.get(node.val), node, depth + 1, k);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode.printTree(treeNode);
        for (Integer i : new LC863().distanceK(treeNode, new TreeNode(5), 2)) {
            System.out.println(i);
        }
    }
}
