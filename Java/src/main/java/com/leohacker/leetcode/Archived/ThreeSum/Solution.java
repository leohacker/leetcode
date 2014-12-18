package com.leohacker.leetcode.Archived.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leojiang on 12/18/14.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (num.length <= 2) {
            return results;
        }
        Arrays.sort(num);

        // The array:  i start .... .... end .
        // for loop the i from head to tail, the range of start .. end is the rest of array.
        // move the start pointer forwards and end pointer backwards.
        for (int i = 0; i < num.length; ) {
            int start = i + 1;
            int end = num.length - 1;

            while ( start < end ) {
                int sum = num[i] + num[start] + num[end];
                if ( sum == 0 ) {   // if equals, move the start
                    addTuple(results, num[i], num[start], num[end]);
                    start++;
                    end--;
                    // jump the repeating number for start.
                    while( start < end && num[start] == num[start-1]) {
                        start++;
                    }
                    // jump the repeating number for end.
                    while(start < end && num[end] == num[end+1]) {
                        end--;
                    }
                } else if ( sum < 0) {
                    start++;
                    while( start < end && num[start] == num[start-1]) {
                        start++;
                    }
                } else {
                    end--;
                    while(start < end && num[end] == num[end+1]) {
                        end--;
                    }
                }
            }
            // jump the repeating i number.
            i++;
            while( i < num.length && num[i] == num[i-1]) {
                i++;
            }
        }
        return results;
    }


    private void addTuple(List<List<Integer>> results, Integer a, Integer b, Integer c) {
        List<Integer> tuple = new ArrayList<Integer>();
        tuple.add(a);
        tuple.add(b);
        tuple.add(c);
        results.add(tuple);
    }
}
