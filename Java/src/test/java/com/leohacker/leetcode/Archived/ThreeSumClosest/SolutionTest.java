package com.leohacker.leetcode.Archived.ThreeSumClosest;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testThreeSumClosest() throws Exception {
        Solution solution = new Solution();
        int[] a = {-3, -2, -5, 3, -4};
        int target = -1;
        solution.threeSumClosest(a, target);
    }
}
