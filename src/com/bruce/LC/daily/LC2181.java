package com.bruce.LC.daily;

import com.bruce.LC.linkedList.ListNode;

public class LC2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode();
        ListNode current = ans;
        int sum = 0;
        while (head != null) {
            if (head.val == 0 && sum != 0) {
                current.val = sum;
                if (head.next != null) {
                    current.next = new ListNode();
                }
                current = current.next;
                sum = 0;
            }
            sum += head.val;
            head = head.next;
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LC2181().mergeNodes(new ListNode(new int[]{0, 3, 1, 0, 4, 5, 2, 0})).toString());
    }
}
