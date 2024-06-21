package com.bruce.LC.daily;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-03 14:25
 **/
public class ListNode {
    Object val;
    ListNode next;

    ListNode() {
    }

    ListNode(Object val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
