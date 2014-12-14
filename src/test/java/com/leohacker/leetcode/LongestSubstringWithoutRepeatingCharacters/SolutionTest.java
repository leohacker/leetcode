package com.leohacker.leetcode.LongestSubstringWithoutRepeatingCharacters;

import junit.framework.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring
                ("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
        Assert.assertEquals(12, len);
    }
}
