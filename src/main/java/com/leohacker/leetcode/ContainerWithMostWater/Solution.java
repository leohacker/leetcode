package com.leohacker.leetcode.ContainerWithMostWater;

/**
 * Created by leojiang on 12/17/14.
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length -1;

        while ( i < j ) {
            int area = (j-i) * Math.min(height[i], height[j]);
            maxArea = area > maxArea ? area : maxArea;
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
