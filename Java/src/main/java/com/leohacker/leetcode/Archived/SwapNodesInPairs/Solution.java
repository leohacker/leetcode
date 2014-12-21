package com.leohacker.leetcode.Archived.SwapNodesInPairs;

import com.leohacker.leetcode.utils.ListNode;

/**
 * Created by leojiang on 12/20/14.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dumbHead = new ListNode(0);
        dumbHead.next = head;

        ListNode dumb = dumbHead;
        while(dumb.next != null && dumb.next.next!=null) {
            ListNode first = dumb.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            dumb.next = second;
            dumb = first;
        }

        return dumbHead.next;
    }
}
