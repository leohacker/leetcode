package com.leohacker.leetcode.MergeSortedArray;

/**
 * 在简单算法的基础上，改进空间的利用。
 * A数组的后部空间是空闲的，所以我们可以直接从数组的尾部开始比较，然后从大到小的方式存放
 * 到最终数组中。
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m + n - 1;
        m--;
        n--;
        while ( m >= 0 && n >= 0 ) {
            // 取A和B的末尾中最大的数放在最终数组的尾部。
            // 伪码：A[i] = max(A[m], B[n])
            if ( A[m] > B[n] ) {
                A[i] = A[m];
                m--;
            } else {
                A[i] = B[n];
                n--;
            }
            i--;
        }

        // 如果数组A中的数据已经用完，将数组B中剩余的数据填入数组A。
        // 如果数组B中的数据用完，则不用改变，因为数组A的数据已经在那里。
        if ( m < 0 && n >= 0 ) {
            while ( n >= 0 ) {
                A[i] = B[n];
                n--;
                i--;
            }
        }

    }
}
