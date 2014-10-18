package com.leohacker.leetcode.ReverseInteger;

/**
 * Created by leojiang on 10/18/14.
 */
public class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        if (x < 0) {
            sb = sb.deleteCharAt(0);
        }
        String revStr = sb.reverse().toString();
        if (x < 0) {
            revStr = '-' + revStr;
        }
        Integer i = Integer.parseInt(revStr);
        return i.intValue();
    }
}
