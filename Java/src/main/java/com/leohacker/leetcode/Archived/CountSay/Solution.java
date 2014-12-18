package com.leohacker.leetcode.Archived.CountSay;

/**
 * 计数并且构造新的字符串。
 */
public class Solution {
    public String countAndSay(int n) {
        String current = "1";
        n--;
        for (int i = 0; i < n; i++) {
            StringBuilder next = new StringBuilder("");
            int j = 0;
            int length = current.length();
            while ( j < length ) {
                char c = current.charAt(j);
                int count = 0;
                while (j < length && c == current.charAt(j)) {
                    count++;
                    j++;
                }
                next.append(count);
                next.append(c);
            }
            current = next.toString();
        }

        return current;
    }
}
