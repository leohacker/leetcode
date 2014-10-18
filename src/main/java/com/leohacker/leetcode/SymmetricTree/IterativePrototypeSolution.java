package com.leohacker.leetcode.SymmetricTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 非递归的方式判断这棵树是否是对称的。广度遍历，一层层判断是否对称。如果都是空指针，遍历结束。
 * 考虑判断对称的需求，保存每层数据的队列要保存所有的空指针，也就是完全二叉树。
 */
public class IterativePrototypeSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);

        boolean empty = isEmpty(list);
        boolean symmetric = isSymmetricList(list);

        while (!empty && symmetric) {
            List<TreeNode> newlist = new ArrayList<TreeNode>();
            for (TreeNode node : list) {
                if ( node == null ) {
                    newlist.add(null);
                    newlist.add(null);
                } else {
                    newlist.add(node.left);
                    newlist.add(node.right);
                }
            }
            empty = isEmpty(newlist);
            symmetric = isSymmetricList(newlist);
            list = newlist;
        }
        return empty ? true : false;
    }

    private boolean isEmpty(List<TreeNode> list) {
        int index = list.size();
        index--;
        while ( (index >= 0) && list.get(index) == null ) {
            index--;
        }
        return (index < 0) ? true : false;
    }

    private boolean isSymmetricList(List<TreeNode> list) {
        int left = 0;
        int right = list.size() - 1;
        boolean symmetic = true;
        while(left < right && symmetic) {
            TreeNode leftNode = list.get(left);
            TreeNode rightNode = list.get(right);

            if ( leftNode == rightNode ) {
                symmetic = true;
            } else if ( leftNode == null || rightNode == null) {
                symmetic = false;
            } else {
                symmetic = (leftNode.val == rightNode.val) ? true : false;
            }
            left++;
            right--;
        }
        return symmetic;
    }
}
