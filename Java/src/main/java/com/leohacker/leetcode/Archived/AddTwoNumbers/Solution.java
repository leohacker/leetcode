package com.leohacker.leetcode.Archived.AddTwoNumbers;

import com.leohacker.leetcode.utils.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        int addition = 0;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while ( p1 != null && p2 != null ) {
            int val = p1.val + p2.val + addition;
            if ( val >= 10 ) {
                addition = 1;
                val = val - 10;
            } else {
                addition = 0;
            }
            ListNode cur = new ListNode(val);
            pre.next = cur;
            pre = cur;

            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode rest = (p1 == null ? p2 : p1);
        while ( rest != null ) {
            int val = rest.val + addition;
            if ( val >= 10 ) {
                addition = 1;
                val = val - 10;
            } else {
                addition = 0;
            }
            ListNode cur = new ListNode(val);
            pre.next = cur;
            pre = cur;

            rest = rest.next;
        }

        if ( addition == 1 ) {
            ListNode cur = new ListNode(1);
            pre.next = cur;
        }

        return head.next;
    }
}
