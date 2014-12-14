package com.leohacker.leetcode.Archived.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null ) {
            return 0;
        }
        if ( s.length() <= 1) {
            return s.length();
        }

        char[] stringArray = s.toCharArray();
        Map<Character, Boolean> existMap = new HashMap<Character, Boolean>();
        existMap.put(stringArray[0], true);

        int maxLength = 0;
        int begin = 0;
        int length = stringArray.length;
        for ( int index = 1 ; index < length; index++ ) {
            char c = stringArray[index];

            if (existMap.containsKey(c)) {
                int len = index - begin;
//                System.out.println(String.format("index: %d, begin: %d", index, begin));
                if (len > maxLength) {
                    maxLength = len;
                }

                // remove the characters before the repeating character.
                while (stringArray[begin] != c) {
                    existMap.remove(stringArray[begin]);
                    begin++;
                }
                existMap.remove(stringArray[begin]);
                begin++;
            }
            existMap.put(c, true);
        }

        int len = length - begin;
        if ( len > maxLength ) {
            maxLength = len;
        }

        return maxLength;
    }
}
