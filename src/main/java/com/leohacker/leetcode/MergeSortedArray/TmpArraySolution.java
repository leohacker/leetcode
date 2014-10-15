package com.leohacker.leetcode.MergeSortedArray;

/**
 * 创建一个临时数组，存放原来A数组中的数据。从前向后遍历待合并的两个数组，
 * 结果存放在数组A中。
 *
 * 优点是算法的思路简单。
 * 缺点是使用了额外的空间。
 */
public class TmpArraySolution {
    public void merge(int A[], int m, int B[], int n) {
        int[] tmp = new int[m];
        System.arraycopy(A, 0, tmp, 0, m);
        int indexA =0;
        int indexB =0;
        for (int i = 0; i < (m+n); i++) {
            if (indexA < m && indexB < n) {
                if(tmp[indexA] <= B[indexB]) {
                    A[i] = tmp[indexA];
                    indexA++;
                } else {
                    A[i] = B[indexB];
                    indexB++;
                }
            } else if (indexA == m) { // reach the end of A.
                A[i] = B[indexB];
                indexB++;
            } else { // reach the end of B.
                A[i] = tmp[indexA];
                indexA++;
            }
        }

    }
}
