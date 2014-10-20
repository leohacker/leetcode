package com.leohacker.leetcode.BalancedBinaryTree;

import com.leohacker.leetcode.utils.TreeNode;

/**
 * Created by leojiang on 10/20/14.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root) < 0 ? false : true;
    }

    private int isBalancedTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedTree(root.left);
        int right = isBalancedTree(root.right);

        if (left < 0 || right < 0) {
            return -1;
        }
        if (left == right || left == right + 1 || left == right - 1) {
            return ( left > right ) ? left+1 : right+1;
        } else {
            return -1;
        }
    }
}
