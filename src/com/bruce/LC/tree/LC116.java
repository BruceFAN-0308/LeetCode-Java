package com.bruce.LC.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);

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

        // 返回根节点
        return root;
    }

    public static void main(String[] args) {
        new LC116().connect(new Node(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
