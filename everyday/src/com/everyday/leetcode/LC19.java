package com.everyday.leetcode;

import java.util.*;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-03 14:18
 **/
public class LC19 {


    public static void main(String[] args) {

//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode listNode = new ListNode(1, new ListNode(2, null));

        new LC19().removeNthFromEnd(listNode, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode listNode = head;

        int length = 1;
        while (listNode.next != null) {
            length++;
            listNode = listNode.next;
        }
        if (length == 1 && n == 1) {
            return null;
        }
        if (length == n) {
            return head.next;
        }
        ListNode current = head;

        for (int i = 1; i < length - n; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;

    }

}
