package com.leohacker.leetcode.ConstructBinaryTreeFromInorderPostorderTraversal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private int[] inorder;
    private int[] postorder;
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        inorder = new int[] { 4, 2, 5, 1, 3, 7 };
        postorder = new int[] { 4, 5, 2, 7, 3, 1 };
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testBuildTree() throws Exception {
        solution.buildTree(inorder, postorder);
    }
}
