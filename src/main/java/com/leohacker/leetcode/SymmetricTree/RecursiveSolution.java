package com.leohacker.leetcode.SymmetricTree;

/**
 * 递归判断左右子树是否镜像。
 */
public class RecursiveSolution {
    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if ((a == null) && (b == null)) {
            return true;
        } else if ((a == null) || (b == null)) {
            return false;
        }

        if(a.val != b.val) {
            return false;
        } else {
            return isMirror(a.left, b.right) && isMirror(a.right, b.left);
        }
    }
}
