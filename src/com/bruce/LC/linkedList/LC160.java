package com.bruce.LC.linkedList;

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }


        return a;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(new int[]{4, 1, 8, 4, 5});
        ListNode listNode2 = new ListNode(new int[]{5, 6, 1, 8, 4, 5});
        System.out.println(new LC160().getIntersectionNode(listNode1, listNode2));
    }
}
