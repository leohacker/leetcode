package com.leohacker.leetcode.Archived.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Classic.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ( numRows == 0 ) {
            return result;
        }
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        result.add(row);
        List<Integer> last = row;
        for (int i = 1; i < numRows; i++) {
            row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int num = last.get(j - 1).intValue() + last.get(j).intValue();
                    row.add(new Integer(num));
                }
            }
            result.add(row);
            last = row;
        }
        return result;
    }
}
