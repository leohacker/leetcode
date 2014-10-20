package com.leohacker.leetcode.PathSumII;

import com.leohacker.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by leojiang on 10/16/14.
 */
public class CutBothSolution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ( root == null ) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Boolean> flag = new Stack<Boolean>();
        stack.push(root);
        flag.push(false);

        // current equals the sum of val in the stack.
        int current = root.val;

        while ( !stack.isEmpty() ) {
            TreeNode node = stack.pop();
            boolean isAccessed = flag.pop();

            if ( node.left == null && node.right == null ) {
                if ( !isAccessed && current == sum ) {
                    List<Integer> list = new ArrayList<Integer>();
                    for ( TreeNode n : stack ) {
                        list.add(new Integer(n.val));
                    }
                    list.add(new Integer(node.val));
                    result.add(list);
                }
                current -= node.val;
            }

            if ( node.left != null ) {
                TreeNode left = node.left;
                node.left = null;
                stack.push(node);
                flag.push(true);
                stack.push(left);
                flag.push(false);
                current += left.val;
            } else if ( node.right != null ) {
                TreeNode right = node.right;
                node.right = null;
                stack.push(node);
                flag.push(true);
                stack.push(right);
                flag.push(false);
                current += right.val;
            }
        }
        return result;
    }
}
