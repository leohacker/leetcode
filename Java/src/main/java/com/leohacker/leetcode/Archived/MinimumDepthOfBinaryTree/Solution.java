package com.leohacker.leetcode.Archived.MinimumDepthOfBinaryTree;

import com.leohacker.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Still can be optimized.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);

        TreeNode p = null;
        int level = 0;
        boolean found = false;
        while (!list.isEmpty() && !found) {
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
                if (p.left == null && p.right == null) {
                    found = true;
                }
            }
            for (int i = 0; i < len; i++) {
                list.remove(0);
            }
        }
        return level;
    }
}
