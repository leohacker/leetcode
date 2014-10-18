package com.leohacker.leetcode.PathSum;

/**
 * Simple!
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if( root == null ) {
            return false;
        }
        int current = 0;
        return traverse(root, sum, current);
    }

    private boolean traverse(TreeNode root, int sum, int current) {
        if (root == null) {
            return false;
        }
        current = current + root.val;
        if (root.left == null && root.right == null && current == sum) {
            return true;
        }
        return traverse(root.left, sum, current) || traverse(root.right, sum, current);
    }
}
