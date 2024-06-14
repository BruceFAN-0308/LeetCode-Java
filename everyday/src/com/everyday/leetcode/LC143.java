package com.everyday.leetcode;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-03-23 16:54
 **/
/*
* You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
* */
public class LC143 {

    public static void main(String[] args) {

        new LC143().reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));

    }


    // slow fast double index
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null, next = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = prev;

        while (prev.next != null) {
            next = firstHalf.next;
            prev = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = next;

            firstHalf = next;
            secondHalf = prev;
        }

    }
}
