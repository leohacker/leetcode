package com.leohacker.leetcode.Archived.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leojiang on 12/20/14.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length < 4) {
            return result;
        }

        Arrays.sort(num);
        int length = num.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            map.put(num[i], i);
        }


        List<Integer> tuple = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            int a = num[i];
            for (int j = i + 1; j < length; j++) {
                int b = num[j];
                for (int k = j + 1; k < length; k++) {
                    int c = num[k];
                    int d = target - a - b - c;
                    if (d < c) {
                        break;
                    }

                    if (map.containsKey(d) && map.get(d) > k) {
                        addTuple(result, a, b, c, d);
                    }

                    while( k < length-1 && num[k] == num[k+1]) {
                        k++;
                    }
                }
                while( j < length-1 && num[j] == num[j+1]) {
                    j++;
                }
            }
            while( i < length-1 && num[i] == num[i+1]) {
                i++;
            }
        }
        return result;
    }

    private void addTuple(List<List<Integer>> results,
                          Integer a, Integer b, Integer c, Integer d) {
        List<Integer> tuple = new ArrayList<Integer>();
        tuple.add(a);
        tuple.add(b);
        tuple.add(c);
        tuple.add(d);
        results.add(tuple);
    }

}
