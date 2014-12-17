package com.leohacker.leetcode.Archived.ContainerWithMostWater;

/**
 * 从数组的两端开始，向中间计算。容积 = (j-i) * min(h[i], h[j])。
 * 如果 i 的高度比 j 的高度低，那么在 i 不变的情况，改变 j 只能让容积更小。
 * 所以每次移动高度值小的那个，寻找可能使容积更大的 i 和 j 。
 *
 * 算法还可以优化，不过会使代码复杂，条件判断变多。
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
