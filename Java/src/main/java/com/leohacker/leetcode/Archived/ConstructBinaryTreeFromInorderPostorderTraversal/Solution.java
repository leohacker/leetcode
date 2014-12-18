package com.leohacker.leetcode.Archived.ConstructBinaryTreeFromInorderPostorderTraversal;

import com.leohacker.leetcode.utils.TreeNode;

import java.util.Arrays;

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
            int[] leftInorder = Arrays.copyOf(inorder, indexRoot);
            int[] leftPostorder = Arrays.copyOf(postorder, indexRoot);
            node.left = buildTree(leftInorder, leftPostorder);
        }

        if ( length - indexRoot - 1 == 0 ) {
            node.right = null;
        } else {
            int[] rightInorder = Arrays.copyOfRange(inorder, indexRoot+1, length);
            int[] rightPostorder = Arrays.copyOfRange(postorder, indexRoot, length -1);
            node.right  = buildTree(rightInorder, rightPostorder);
        }
        return node;
    }
}
