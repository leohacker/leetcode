package com.leohacker.leetcode.Archived.IntegerToRoman;

/**
 * Created by leojiang on 12/17/14.
 */
public class Solution {
    public String intToRoman(int num) {
        String[] roman = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String result = "";
        int index = 0;
        while ( num > 0 ) {
            int mod = num % 10;
            String modstring = roman[mod];
            if ( index == 1 ) {
                modstring = modstring.replaceAll("X", "C");
                modstring = modstring.replaceAll("V", "L");
                modstring = modstring.replaceAll("I", "X");
            } else if ( index == 2 ) {
                modstring = modstring.replaceAll("X", "M");
                modstring = modstring.replaceAll("V", "D");
                modstring = modstring.replaceAll("I", "C");
            } else if ( index == 3 ) {
                modstring = modstring.replaceAll("I", "M");
            }
            index++;
            result = modstring + result;
            num = num / 10;
        }

        return result;
    }
}
