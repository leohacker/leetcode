package com.leohacker.leetcode.MaximumDepthOfBinaryTree;

import com.leohacker.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Still can be optimized.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);

        TreeNode p = null;
        int level = 0;
        while (!list.isEmpty()) {
            level++;
            int len = list.size();
            for (int i = 0; i < len; i++) {
                p = list.get(i);
                if (p.left != null) {
                    list.add(p.left);
                }
                if (p.right != null) {
                    list.add(p.right);
                }
            }
            for (int i = 0; i < len; i++) {
                list.remove(0);
            }
        }
        return level;
    }
}
