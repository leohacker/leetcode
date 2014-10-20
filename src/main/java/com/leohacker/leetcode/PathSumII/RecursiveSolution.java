package com.leohacker.leetcode.PathSumII;

import com.leohacker.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecursiveSolution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private Stack<Integer> stack = new Stack<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            traverse(root, sum, 0);
        }
        return result;
    }

    private void traverse(TreeNode root, int sum, int current) {
        current += root.val;
        if (root.left == null && root.right == null) {    // left node
            if (current == sum) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (Integer e : stack) {
                    tmp.add(e);
                }
                tmp.add(root.val);
                result.add(tmp);
            }
        } else {
            stack.push(root.val);
            if (root.left != null) {
                traverse(root.left, sum, current);
            }
            if (root.right != null) {
                traverse(root.right, sum, current);
            }
            stack.pop();
        }
    }
}

