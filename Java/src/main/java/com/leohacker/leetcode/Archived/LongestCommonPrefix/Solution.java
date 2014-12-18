package com.leohacker.leetcode.Archived.LongestCommonPrefix;

/**
 * Created by leojiang on 10/3/14.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }

        int min = strs[0].length();
        for (int i = 0; i < length; i++) {
            int len = strs[i].length();
            if (len < min) {
                min = len;
            }
        }

        String pattern = strs[0].substring(0, min);
        int patternLength = pattern.length();
        int i = 0;
        boolean found = false;
        while (i < patternLength && ! found ) {
            char c = pattern.charAt(i);
            for (int j = 0; j < length; j++) {

                if (c != strs[j].charAt(i)) {
                    found = true;
                    break;
                }
            }
            i++;
        }
        if (found) {
            i--;
        }
        return pattern.substring(0, i);
    }
}
