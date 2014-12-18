package com.leohacker.leetcode.Archived.LengthOfLastWord;

/**
 * Created by leojiang on 10/20/14.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split("\\s");
        if ( words.length == 0) {
            return 0;
        }
        String last = words[words.length -1];
        return last.length();
    }
}
