package com.leohacker.leetcode.Archived.RomanToInteger;

/**
 * Created by leojiang on 12/17/14.
 */
public class Solution {
    public int romanToInt(String s) {
        char[] chArray = s.toCharArray();
        int[] intArray = new int[chArray.length];

        for (int i = 0; i < chArray.length; i++) {
            char ch = chArray[i];
            switch (ch) {
                case 'I':
                    intArray[i] = 1;
                    break;
                case 'V':
                    intArray[i] = 5;
                    break;
                case 'X':
                    intArray[i] = 10;
                    break;
                case 'L':
                    intArray[i] = 50;
                    break;
                case 'C':
                    intArray[i] = 100;
                    break;
                case 'D':
                    intArray[i] = 500;
                    break;
                case 'M':
                    intArray[i] = 1000;
                    break;
                default:
                    intArray[i] = 0;
            }
        }

        int pre = 0;
        int sum = 0;
        for (int num : intArray) {
            if (num > pre) {
                sum = sum + num - pre * 2;
            } else {
                sum = sum + num;
            }
            pre = num;
        }
        return sum;
    }
}
