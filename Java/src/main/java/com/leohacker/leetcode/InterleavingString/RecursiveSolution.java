package com.leohacker.leetcode.InterleavingString;

// Time Limit Exceeded.
public class RecursiveSolution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ( s3 == null ) {
            return false;
        }

        if (s1 == null || s1.isEmpty()) {
            return s3.equals(s2) ? true : false;
        }
        if (s2 == null || s2.isEmpty()) {
            return s3.equals(s1) ? true : false;
        }

        if (s3.equals("")) {
            return (!s1.isEmpty() || !s2.isEmpty()) ? false : true;
        }

        if ( s3.equals(s1 + s2) || s3.equals(s2 + s1)) {
            return true;
        }
        char a = s1.charAt(0);
        char b = s2.charAt(0);
        char c = s3.charAt(0);
        String next = s3.substring(1);
        return (a == c && isInterleave(s1.substring(1), s2, next)) || (b == c && isInterleave(s1, s2.substring(1), next));
    }
}
