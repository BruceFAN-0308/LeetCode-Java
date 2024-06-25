package com.bruce.LC.daily;

public class LC1038 {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }


    public static void main(String[] args) {
        Integer[] tree = new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode treeNode = new TreeNode(tree);
        TreeNode.printTree(treeNode);
        TreeNode node = new LC1038().bstToGst(treeNode);
        TreeNode.printTree(node);
    }
}
