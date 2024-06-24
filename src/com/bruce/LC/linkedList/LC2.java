package com.bruce.LC.linkedList;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode current = listNode;

        boolean overTen = false;
        while (l1 != null || l2 != null) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int temp = l1Value + l2Value;
            if (overTen) {
                temp++;
            }
            overTen = temp >= 10;
            if (overTen) {
                current.val = temp - 10;
            } else {
                current.val = temp;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (!overTen && l1 == null && l2 == null) {
                break;
            }
            current.next = new ListNode();
            current = current.next;

        }
        if (overTen) {
            current.val = 1;
        }
        return listNode;
    }

    public static void main(String[] args) {
        System.out.println(new LC2().addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4})));
    }
}
