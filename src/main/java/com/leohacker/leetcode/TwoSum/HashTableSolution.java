package com.leohacker.leetcode.TwoSum;

import java.util.HashMap;

/*
    HashTable Solution.
 */
public class HashTableSolution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = {0, 0};

        int length = numbers.length;
        if ( length <= 1 ) {
            return indices;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(numbers[0], 0 + 1);

        int i = 1;
        while ( i < length ) {
            if (map.containsKey(target - numbers[i])) {
                indices[0] = map.get(target - numbers[i]);
                indices[1] = i+1;
                break;
            }
            map.put(numbers[i], i+1);
            i++;
        }
        return indices;
    }

}
