package com.leohacker.leetcode.Archived.RemoveElement;

/**
 * Created by leojiang on 10/20/14.
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;

        while ( left != right ) {
            if (A[left] != elem) {
                left++;
            } else {
                A[left] = A[right];
                right--;
            }
        }

        return A[left] == elem ? left : left + 1;
    }
}
