package com.leohacker.leetcode.ReverseInteger;

import org.junit.Test;

public class SolutionTest {


    @Test
    public void testReverse() throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(-120));
        System.out.println(solution.reverse(1000000003));
    }
}
