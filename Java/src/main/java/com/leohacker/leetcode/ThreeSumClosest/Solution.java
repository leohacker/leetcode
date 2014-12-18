package com.leohacker.leetcode.ThreeSumClosest;

import java.util.Arrays;

/**
 * Created by leojiang on 12/18/14.
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int length = num.length;
        if (length == 0) return 0;
        if (length == 1) return num[0];
        if (length == 2) return num[0] + num[1];

        int sum = num[0] + num[1] + num[2];
        if (length == 3) return sum;

        Arrays.sort(num);
        int offset = sum - target;
        int absoffset = Math.abs(offset);

        for (int i = 0; i < length; i++) {
            int start = i + 1;
            int end = length - 1;

            while ( start < end ) {
                sum = num[i] + num[start] + num[end];
                if ( sum == target ) {
                    return sum;
                } else if (sum > target) {
                    if ( sum - target < absoffset ) {
                        offset = sum - target;
                        absoffset = Math.abs(offset);
                    }
                    end--;
                } else {
                    if ( target - sum < absoffset ) {
                        offset = sum - target;
                        absoffset = Math.abs(offset);
                    }
                    start++;
                }
            }
        }

        return target + offset;
    }
}
