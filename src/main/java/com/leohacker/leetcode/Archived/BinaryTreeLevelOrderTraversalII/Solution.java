package com.leohacker.leetcode.Archived.BinaryTreeLevelOrderTraversalII;

import com.leohacker.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
        int size = result.size();
        for (int i = 0; i < size; i++) {
            finalResult.add(result.get(size - 1 - i));
        }
        return finalResult;
    }
}
