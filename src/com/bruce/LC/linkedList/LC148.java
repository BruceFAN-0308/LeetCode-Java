package com.bruce.LC.linkedList;

import java.util.ArrayList;
import java.util.Collections;

public class LC148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode();
        ListNode current = result;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                current.next = new ListNode();
            }
            current.val = list.get(i);
            current = current.next;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC148().sortList(new ListNode(new int[]{4, 2, 1, 3})).toString());
    }
}
