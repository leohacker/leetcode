package com.leohacker.leetcode.ClimbingStairs;

/**
 * 假设你从楼梯顶向下走。你可以迈一步或者两步。递归的想，于是就是一个 Fibonacci 函数。
 * F(n) = F(n-2) + F(n-1)
 */
public class Solution {
    public int climbStairs(int n) {
        if (( n == 0 ) || ( n == 1 )) {
            return 1;
        }

        int first = 1;
        int second = 1;

        for (int i = 1; i < n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }
        return second;
    }
}
