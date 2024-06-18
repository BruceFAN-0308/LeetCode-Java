package com.everyday.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-04-08 23:06
 **/
public class CircularLinkedList {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("庄", "金", "蔡", "范");
        Collections.shuffle(strings);

        com.everyday.leetcode.ListNode head = null;
        com.everyday.leetcode.ListNode tail = null;

        for (String str : strings) {
            com.everyday.leetcode.ListNode newNode = new com.everyday.leetcode.ListNode(str);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Forming the circular linked list
        if (tail != null) {
            tail.next = head;
        }

        com.everyday.leetcode.ListNode current = head;
        do {
            System.out.print(current.val + "->");
            current = current.next;
        } while (current != head);
        System.out.println(head.val);

    }
}