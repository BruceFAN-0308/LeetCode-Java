package com.bruce.LC.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        this.val = arr[0];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(this);
        int i = 1;

        while (i < arr.length) {
            Node current = queue.poll();
            if (current == null) {
                continue;
            }

            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
    }
}
