package com.leohacker.leetcode.String2Integer;

/**
 * Created by leojiang on 10/18/14.
 */
public class Solution {
    private static final int INT_MAX = 2147483647;
    private static final int INT_MIN = -2147483648;

    public int atoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.equals("")) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(str);
        int sign = 1;
        char c = sb.charAt(0);
        if (c == '+') {
            sb.deleteCharAt(0);
            sign = 1;
        }
        if (c == '-') {
            sb.deleteCharAt(0);
            sign = -1;
        }

        int index = 0;
        int length = sb.length();
        int sum = 0;

        while (index < length) {
            c = sb.charAt(index);
            if ( c >= '0' && c <= '9' ) {
                int num = c - '0';
                if ( sign == 1 ) {
                    if (INT_MAX / 10 < sum || (INT_MAX / 10  == sum && num >= 8)) {
                        sum = INT_MAX;
                        break;
                    }
                }
                if ( sign == -1 ) {
                    if (INT_MIN / 10 > sum || (INT_MIN / 10 == sum && num == 9 )) {
                        sum = INT_MIN;
                        break;
                    }
                }

                sum = sum * 10 + sign * num;
                index++;
            } else {
                break;
            }
        }
        return sum;
    }
}
