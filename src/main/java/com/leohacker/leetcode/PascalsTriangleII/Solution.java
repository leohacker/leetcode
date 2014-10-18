package com.leohacker.leetcode.PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * 优化的诀窍在于不要使用List.set(index, e)方法。这个方法本身是要遍历一遍的。
 * 对于链表而言，在尾部添加和头部删除，更加容易。
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j <=i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(row.get(j-1) + row.get(j));
                }
            }

            for (int j = 0; j < i; j++) {
                row.remove(0);
            }
        }
        return row;
    }
}
