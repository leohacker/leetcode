package com.leohacker.leetcode.Archived.PlusOne;

/**
 * Created by leojiang on 10/20/14.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int index = len - 1;
        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0;
            index--;
        }
        if ( index >= 0 ) {
            digits[index] = digits[index] + 1;
            return digits;
        } else {
            int[] result = new int[len+1];
            for (int i = 1; i < len+1; i++) {
                result[i] = 0;
            }
            result[0] = 1;
            return result;
        }
    }
}
