package com.leohacker.leetcode.PalindromeNumber;

import junit.framework.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isPalindrome(1000021));
    }

}
