package com.leohacker.leetcode.PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leojiang on 10/18/14.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        if ( rowIndex == 0 ) {
            return row;
        }
        if ( rowIndex == 1 ) {
            row.add(1);
            return row;
        } else {
            for (int i = 1; i < rowIndex; i++) {
                row.add(1);
                int j = i - 1;
                int cur = row.get(j).intValue();
                while( j > 0 ) {
                    int pre = row.get(j-1).intValue();
                    row.set(j, cur + pre);
                    cur = pre;
                }
            }
            return row;
        }
    }
}
