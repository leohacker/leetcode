package com.leohacker.leetcode.LongestCommonPrefix;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();

    }

    @Test
    public void testLongestCommonPrefix() throws Exception {
        String[] strs = new String[] {"ab", "ac"};
        String ret = solution.longestCommonPrefix(strs);
        Assert.assertEquals("a", ret);
    }

    @Test
    public void noFound() throws Exception {
        String[] strs = new String[] {"b", "c"};
        String ret = solution.longestCommonPrefix(strs);
        Assert.assertEquals("", ret);
    }

    @Test
    public void single() throws Exception {
        String[] strs = new String[] {"b"};
        String ret = solution.longestCommonPrefix(strs);
        Assert.assertEquals("b", ret);
    }

    @Test
    public void shorter() throws Exception {
        String[] strs = new String[] {"bc", "b"};
        String ret = solution.longestCommonPrefix(strs);
        Assert.assertEquals("b", ret);
    }


}
