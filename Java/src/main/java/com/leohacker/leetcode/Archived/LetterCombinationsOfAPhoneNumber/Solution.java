package com.leohacker.leetcode.Archived.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Almost 1A. Great!
 * construct a int[] of index for sub array , and increase the number 1 step by step,
 * and accumulate the addition flag.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] keyboard = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };

        List<String> result = new ArrayList<String>();
        if (digits == null ) {
            return result;
        }
        if (digits.length() == 0) {
            result.add("");
            return result;
        }

        int length = digits.length();
        char[] chArray = digits.toCharArray();
        int[] indexArray = new int[length];
        for (int i = 0; i < length; i++) {
            indexArray[i] = chArray[i] - '0';
        }

        int[] subIndexArray = new int[length];
        Arrays.fill(subIndexArray, 0);

        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(keyboard[indexArray[i]][subIndexArray[i]]);
            }
            result.add(sb.toString());

            boolean addition;
            int i = 0;
            do {
                addition = false;
                subIndexArray[i]++;
                if (subIndexArray[i] == 4 ||
                    (subIndexArray[i] == 3 && indexArray[i] != 9 && indexArray[i] != 7)
                    ) {
                    subIndexArray[i] = 0;
                    addition = true;
                    i++;
                }
            } while ( addition && i != length );

            if ( i == length ) {
                break;
            }
        }
        return result;
    }

}
