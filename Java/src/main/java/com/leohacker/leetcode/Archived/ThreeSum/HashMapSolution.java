package com.leohacker.leetcode.Archived.ThreeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by leojiang on 12/17/14.
 */
public class HashMapSolution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (num.length <= 2) {
            return results;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // construct the hash map.
        for (int i : num) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // if the number of 0 is over or equal 3.
        if ( map.containsKey(0) && map.get(0) >= 3 ) {
            addTuple(results, 0, 0, 0);
        }

        Set<Integer> keys = map.keySet();
        List<Integer> positiveList = new ArrayList<Integer>();
        List<Integer> negativeList = new ArrayList<Integer>();

        for (Integer key : keys) {
            if ( key > 0 ) {
                positiveList.add(key);
            }
            if ( key < 0 ) {
                negativeList.add(key);
            }
        }

        Collections.sort(positiveList, Collections.reverseOrder());
        Collections.sort(negativeList);
        Integer[] positiveArray = positiveList.toArray(new Integer[positiveList.size()]);
        Integer[] negativeArray = negativeList.toArray(new Integer[negativeList.size()]);

        for (Integer a : negativeArray) {
            for (Integer c : positiveArray) {
                int b = 0 - a - c;
                if ( a == b || b == c ) {
                    if (map.get(b) > 1) {
                        addTuple(results, a, b, c);
                    }
                } else if (map.containsKey(b) && a < b && b < c) {
                    addTuple(results, a, b, c);
                }
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
