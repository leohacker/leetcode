package com.leohacker.leetcode.SameTree;

import com.leohacker.leetcode.utils.TreeNode;

/**
 * Created by leojiang on 10/20/14.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
