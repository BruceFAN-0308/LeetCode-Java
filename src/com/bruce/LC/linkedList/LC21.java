package com.bruce.LC.linkedList;

public class LC21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        ListNode current = result;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        current.next = list1 == null ? list2 : list1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new LC21().mergeTwoLists(new ListNode(new int[]{1, 2, 4}), new ListNode(new int[]{1, 3, 4}));
        System.out.println(listNode.toString());
    }
}
