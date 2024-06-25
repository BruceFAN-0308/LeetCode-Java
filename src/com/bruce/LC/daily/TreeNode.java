package com.bruce.LC.daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-02-29 18:49
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public TreeNode(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        this.val = arr[0];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (current == null) {
                continue;
            }

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int height = getHeight(root);
        int width = (int) Math.pow(2, height) - 1;
        String[][] res = new String[height][width];

        for (String[] arr : res) {
            Arrays.fill(arr," ");
        }

        fill(res, root, 0, 0, width - 1);

        for (String[] arr : res) {
            for (String s : arr) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    private static void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null) {
            return;
        }
        int mid = (l + r) / 2;
        res[i][mid] = Integer.toString(root.val);
        fill(res, root.left, i + 1, l, mid - 1);
        fill(res, root.right, i + 1, mid + 1, r);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}