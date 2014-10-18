package com.leohacker.leetcode.CountSay;

/**
 * 计数并且构造新的字符串。
 */
public class Solution {
    public String countAndSay(int n) {
        if ( n == 1 ) {
            return "1";
        }
        n--;
        StringBuilder sb = new StringBuilder("1");
        StringBuilder next = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            next = new StringBuilder("");
            int j = 0;
            int length = sb.length();
            while ( j < length ) {
                char c = sb.charAt(j);
                int count = 0;
                while (j < length && c == sb.charAt(j)) {
                    count++;
                    j++;
                }
                next.append(count);
                next.append(c);
            }
            sb = next;
        }

        return next.toString();
    }

}
