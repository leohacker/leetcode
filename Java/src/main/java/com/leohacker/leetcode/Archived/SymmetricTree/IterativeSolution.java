package com.leohacker.leetcode.Archived.SymmetricTree;

import com.leohacker.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用完全二叉树的概念，可以判断是否对称，不过空指针占用空间过大。
 * 优化每层队列的存储数据，在存入队列时就确保队列是对称的。
 * 也就是不用判断已存在的队列是否对称，不过在生成下一层队列的时候，判断响应节点的子节点是否对称。
 * 这样，处理过程中的数据量大大减少。
 */
public class IterativeSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if ( root.left == null || root.right == null) {
            return false;
        }
        if ( root.left.val != root.right.val) {
            return false;
        }

        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root.left);
        list.add(root.right);

        boolean symmetric = true;
        while(symmetric && !list.isEmpty()) {
            List<TreeNode> newlist = new ArrayList<TreeNode>();
            int len = list.size();
            int left = 0;
            int right = len - 1;
            int index = 0;

            while(symmetric && left < right) {
                TreeNode leftNode = list.get(left);
                TreeNode rightNode = list.get(right);
                left++;
                right--;

                if (leftNode.val != rightNode.val) {
                    symmetric = false;
                } else {
                    if ((leftNode.left == null && rightNode.right != null)
                            || (leftNode.left != null && rightNode.right == null)) {
                        symmetric = false;
                    } else if (leftNode.left != null) {
                        newlist.add(index, leftNode.left);
                        index++;
                        newlist.add(index, rightNode.right);
                    }

                    if ((leftNode.right == null && rightNode.left != null)
                            || (leftNode.right != null && rightNode.left == null)) {
                        symmetric = false;
                    } else if (leftNode.right != null) {
                        newlist.add(index, leftNode.right);
                        index++;
                        newlist.add(index, rightNode.left);
                    }
                }
            }
            list = newlist;
        }
        return symmetric;
    }
}
