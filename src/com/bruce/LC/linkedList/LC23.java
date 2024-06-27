package com.bruce.LC.linkedList;

import java.util.ArrayList;
import java.util.Collections;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        boolean allEmpty = true;
        for (ListNode list : lists) {
            if (list != null) {
                allEmpty = false;
            }
        }
        if (allEmpty) {
            return null;
        }

        ListNode result = new ListNode();
        ListNode current = result;
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
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
        System.out.println(new LC23().mergeKLists(new ListNode[]{
                new ListNode(new int[]{1, 4, 5}), new ListNode(new int[]{1, 3, 4}), new ListNode(new int[]{2, 6})
        }).toString());
    }
}
