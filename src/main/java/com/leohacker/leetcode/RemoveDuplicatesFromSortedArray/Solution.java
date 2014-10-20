package com.leohacker.leetcode.RemoveDuplicatesFromSortedArray;

/**
 * Created by leojiang on 10/20/14.
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if ( len <= 1 ) {
            return len;
        }

        int curVal = A[0];
        int cur = 0;

        for (int i = 1; i < len; i++) {
            if ( A[i] != curVal ) {
                cur++;
                curVal = A[i];
                A[cur] = curVal;
            }
        }
        return cur + 1;
    }
}
