package com.leohacker.leetcode.Archived.ContainerWithMostWater;

/**
 * Created by leojiang on 12/14/14.
 */
public class SimpleSolution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int maxHeight = 0;
        final int length = height.length;

        for (int i = 0; i < length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                for (int j = i+1; j < length; j++) {
                    int min = height[i] < height[j] ? height[i] : height[j];
                    int area = (j-i) * min;
                    if ( area > maxArea ) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
}
