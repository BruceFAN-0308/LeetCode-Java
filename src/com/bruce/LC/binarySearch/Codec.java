package com.bruce.LC.binarySearch;

import com.bruce.LC.util.TreeNode;

import java.util.*;

// LC297
public class Codec {
    private final String SPLIT = ",";
    private final Deque<String> deque = new ArrayDeque<>();
    private final StringBuilder builder = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        buildString(root);
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    private void buildString(TreeNode node) {
        if (node == null) {
            builder.append("null" + SPLIT);
            return;
        }
        builder.append(node.val + SPLIT);
        buildString(node.left);
        buildString(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(SPLIT);
        for (String s : split) {
            deque.add(s);
        }
        return buildTree();
    }

    private TreeNode buildTree() {
        String poll = deque.poll();
        if (Objects.equals(poll, "null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(poll));
        treeNode.left = buildTree();
        treeNode.right = buildTree();
        return treeNode;
    }

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(new TreeNode(new Integer[]{})));
    }
}
