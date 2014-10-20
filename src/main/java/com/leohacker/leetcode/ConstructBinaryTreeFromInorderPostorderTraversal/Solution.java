package com.leohacker.leetcode.ConstructBinaryTreeFromInorderPostorderTraversal;

import com.leohacker.leetcode.utils.TreeNode;

/**
 * Created by leojiang on 10/3/14.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        if (length == 0) {
            return null;
        }

        // locate the index of root node.
        int root = postorder[length - 1];
        int indexRoot = 0;
        while (inorder[indexRoot] != root) {
            indexRoot++;
        }

        TreeNode node = new TreeNode(root);
        node.left = null;
        node.right = null;

        if (indexRoot == 0) {
            node.left = null;
        } else {
            int[] leftin = new int[indexRoot];
            System.arraycopy(inorder, 0, leftin, 0, indexRoot);
            int[] leftpost = new int[indexRoot];
            System.arraycopy(postorder, 0, leftpost, 0, indexRoot);
            node.left = buildTree(leftin, leftpost);
        }

        if ( length - indexRoot - 1 == 0 ) {
            node.right = null;
        } else {
            int[] rightin = new int[length - indexRoot - 1];
            System.arraycopy(inorder, indexRoot + 1, rightin, 0, length - indexRoot - 1);
            int[] rightpost = new int[length - indexRoot - 1];
            System.arraycopy(postorder, indexRoot, rightpost, 0, length - indexRoot - 1);
            node.right  = buildTree(rightin, rightpost);
        }
        return node;
    }
}
