package com.bruce.LC.linkedList;

public class LC206 {
    public ListNode reverseList(ListNode head) {

        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new LC206().reverseList(new ListNode(new int[]{1, 2, 3, 4, 5})));
    }
}
