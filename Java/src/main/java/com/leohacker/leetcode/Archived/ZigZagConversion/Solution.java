package com.leohacker.leetcode.Archived.ZigZagConversion;

/**
 每次一行的跳跃遍历原始的字符串数组。
 先计算出跳跃的规则：
 在列头和列尾的，每次固定跳跃 2 * (nRows -1);
 在列中间的，第一次跳 2 * (nRows - i - 1) 到 斜线上，再跳 2 * i 回到直线列上。
 于是可以按行遍历数组得出结果。
 */
public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || nRows == 1) {
            return s;
        }
        int length = s.length();
        char[] origin = s.toCharArray();
        char[] array = new char[length];
        int index = 0;

        for (int i = 0; i < nRows; i++) {
            int j = i;
            boolean inColumn = true;
            while (j < length) {
                array[index] = origin[j];
                index++;
                if ( i == 0 || i == nRows -1 ) {
                    j = j + 2 * (nRows - 1);
                } else {
                    j = j + (inColumn ? (2 * (nRows - i - 1)) : 2 * i);
                    inColumn = !inColumn;
                }
            }
        }

        return new String(array);
    }
}
