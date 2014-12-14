package com.leohacker.leetcode.Archived.ZigZagConversion;

import junit.framework.Assert;
import org.junit.Test;



public class SolutionTest {

    @Test
    public void testConvert() throws Exception {
        String s;
        s = new Solution().convert("ABC", 2);
        Assert.assertEquals("ACB", s);

        s = new Solution().convert("PAYPALISHIRING", 3);
        Assert.assertEquals("PAHNAPLSIIGYIR", s);

        s = new Solution().convert("ABCDE", 4);
        Assert.assertEquals("ABCED", s);

        s = new MatrixSolution().convert("ABCDEF", 4);
        Assert.assertEquals("ABFCED", s);
    }
}
