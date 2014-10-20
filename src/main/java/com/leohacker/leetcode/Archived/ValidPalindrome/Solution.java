package com.leohacker.leetcode.Archived.ValidPalindrome;

/**
 * Simple!
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if ( s == null ) {
            return false;
        }
        StringBuilder sb = new StringBuilder("");
        int len = s.length();
        s = s.toLowerCase();
        // construct a clean string.
        while( len > 0 ) {
            len--;
            char c = s.charAt(len);
            if ((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
                sb.append(c);
            }
        }
        String reverse = sb.toString();
        String origin = sb.reverse().toString();
        return (origin.equals(reverse)) ? true : false;
    }
}
