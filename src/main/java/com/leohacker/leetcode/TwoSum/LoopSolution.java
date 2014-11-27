package com.leohacker.leetcode.TwoSum;

/*
    Loop index in the array, and loop from the beginning to current index for answer. O(n2)
 */

public class LoopSolution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = {0, 0};

        int length = numbers.length;
        if ( length <= 1 )  {
            return indices;
        }

        int i = 1;
        while ( i < length ) {
            int j = 0;
            while (j < i) {
                if (numbers[j] + numbers[i] == target) {
                    indices[0] = j+1;
                    indices[1] = i+1;
                    return indices;
                }
                j++;
            }
            i++;
        }
        return indices;
    }
}
