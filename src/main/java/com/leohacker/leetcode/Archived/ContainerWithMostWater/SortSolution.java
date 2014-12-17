package com.leohacker.leetcode.Archived.ContainerWithMostWater;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Sort the array first. O(nlogn)
 */
public class SortSolution {
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
        // construct the list and sort it reversely.
        List<HeightElem> list = new ArrayList<HeightElem>();
        for (int i = 0; i < height.length; i++) {
            list.add(new HeightElem(height[i], i));
        }
        Collections.sort(list, Collections.reverseOrder());

        // iterate the list
        Iterator<HeightElem> itor = list.iterator();
        // get the first element.
        int index = itor.next().index;
        // record the max and min value of index.
        int max = index;
        int min = index;

        HeightElem elem = itor.next();
        index = elem.index;

        // the second element.
        if ( index > max ) {
            max = index;
        } else {
            min = index;
        }

        int maxArea = (max - min) * elem.height;
        int area;
        while ( itor.hasNext() ) {
            elem = itor.next();
            if ( elem.index > max ) {   // if current index > max, then we will get larger area.
                max = elem.index;
                area = (max - min) * elem.height;
                maxArea = (area > maxArea) ? area : maxArea;
            } else if ( elem.index < min) { // else if current index < min, then we will get larger area.
                min = elem.index;
                area = (max - min) * elem.height;
                maxArea = (area > maxArea) ? area : maxArea;
            } // else not change.
        }

        return maxArea;
    }
}
