package com.bruce.LC.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {

            int size = deque.size();

            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                if (i < size - 1) {
                    node.next = deque.peek();
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node connect = new LC117().connect(new Node(new Integer[]{1, 2, 3, 4, 5, null, 7}));
    }
}
