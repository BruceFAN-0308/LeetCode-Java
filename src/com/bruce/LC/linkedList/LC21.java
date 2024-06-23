package com.bruce.LC.linkedList;

public class LC21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0, null);
        while (list1 != null || list2 != null) {
            ListNode temp;
            if (list1 == null) {
                result.next = list2;
                break;
            } else if (list2 == null) {
                result.next = list1;
                break;
            }


            if (list1.val < list2.val) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            result.next = temp;
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC21().mergeTwoLists(new ListNode(new int[]{1, 2, 4}), new ListNode(new int[]{1, 3, 4})));
    }
}
