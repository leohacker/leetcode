package com.leohacker.leetcode.Archived.CopyListWithRandomPointer;

// if you can't the error message,
// refer : https://oj.leetcode.com/discuss/377/anyone-know-what-input-1-2-2-2-output-1-2-%23-%23-expected-1-2-2-2
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if ( head == null ) {
            return null;
        }

        // insert the copy node into original list.
        RandomListNode current = head;
        while( current != null ) {
            RandomListNode node = new RandomListNode(current.label);
            node.random = current.random;
            node.next = current.next;
            current.next = node;
            current = node.next;
        }

        RandomListNode copyListHead = head.next;

        current = head;
        RandomListNode copyNode;
        // fix the random link but we can't fix the next link currently,
        // since if you change the next link, you can't fix the random link correctly.
        while( current != null ) {
            copyNode = current.next;
            if ( copyNode.random != null ) {
                copyNode.random = copyNode.random.next;
            }
            current = copyNode.next;
        }

        // fix the next link, separate the link into two links.
        current = head;
        while( current != null ) {
            copyNode = current.next;
            current.next = copyNode.next;
            current = current.next;
            if ( current != null ) {
                copyNode.next = current.next;
            }
        }

        return copyListHead;
    }
}
