package com.leohacker.leetcode.Archived.RemoveNthNodeFromEndOfList;

import com.leohacker.leetcode.utils.ListNode;

/**
 * 用两个指针来卡住距离n，注意处理删除链表头的情况。
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        ListNode cur = head;

        pre.next = head;

        while (n > 0) {
            cur = cur.next;
            n--;
        }

        while ( cur != null ) {
            cur = cur.next;
            pre = pre.next;
        }

        if ( pre.next == head ) {
            return head.next;
        } else {
            pre.next = pre.next.next;
            return head;
        }
    }

}
