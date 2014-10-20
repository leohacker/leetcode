package com.leohacker.leetcode.Archived.MergeSortedArray;

import org.junit.Test;

public class TmpArraySolutionTest {
    private static TmpArraySolution solution = new TmpArraySolution();

    @Test
    public void testMerge() throws Exception {
        int[] A = new int[] {1, 3, 4, 7};
        int[] B = new int[] {2, 3, 5};
        solution.merge(A, 4, B, 3);
    }
}
