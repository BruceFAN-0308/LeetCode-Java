package com.bruce.LC.linkedList;

public class ListNode {
    public Object val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] nums) {
        ListNode nowNode = new ListNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i > 0; i--) {
            nowNode = new ListNode(nums[i], nowNode);
        }
        this.next = nowNode;
        this.val = nums[0];
    }
}

