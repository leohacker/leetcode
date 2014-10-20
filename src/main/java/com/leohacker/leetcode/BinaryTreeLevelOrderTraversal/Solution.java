package com.leohacker.leetcode.BinaryTreeLevelOrderTraversal;

import com.leohacker.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by leojiang on 10/20/14.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        List<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(root);

        while (!pre.isEmpty()) {
            Iterator<TreeNode> itor = pre.iterator();
            List<Integer> tmp = new ArrayList<Integer>();
            List<TreeNode> generated = new ArrayList<TreeNode>();
            while (itor.hasNext()) {
                TreeNode node = itor.next();
                tmp.add(node.val);
                if (node.left != null) {
                    generated.add(node.left);
                }
                if (node.right != null) {
                    generated.add(node.right);
                }
            }
            result.add(tmp);
            pre = generated;
        }
        return result;
    }
}
