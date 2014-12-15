package com.leohacker.leetcode.Archived.ContainerWithMostWater;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Sort the array first. O(nlogn)
 */
public class Solution {
    private class HeightElem implements Comparable<HeightElem> {
        public int height;
        public int index;

        public HeightElem(int h, int i) {
            height = h;
            index = i;
        }

        @Override
        public int compareTo(HeightElem heightElem) {
            return this.height - heightElem.height;
        }
    }

    public int maxArea(int[] height) {
        List<HeightElem> list = new ArrayList<HeightElem>();

        for (int i = 0; i < height.length; i++) {
            list.add(new HeightElem(height[i], i));
        }

        Collections.sort(list, Collections.reverseOrder());

        Iterator<HeightElem> itor = list.iterator();

        int index = itor.next().index;
        int max = index;
        int min = index;

        HeightElem elem = itor.next();
        index = elem.index;
        if ( index > max ) {
            max = index;
        } else {
            min = index;
        }

        int maxArea = (max - min) * elem.height;
        int area;
        while ( itor.hasNext() ) {
            elem = itor.next();
            if ( elem.index > max ) {
                max = elem.index;
                area = (max - min) * elem.height;
                maxArea = (area > maxArea) ? area : maxArea;
            } else if ( elem.index < min) {
                min = elem.index;
                area = (max - min) * elem.height;
                maxArea = (area > maxArea) ? area : maxArea;
            }
        }

        return maxArea;
    }
}
