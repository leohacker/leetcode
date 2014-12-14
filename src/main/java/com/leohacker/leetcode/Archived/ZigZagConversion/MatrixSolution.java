package com.leohacker.leetcode.Archived.ZigZagConversion;

/*
    居然 Time Limit Exceeded.
 */

public class MatrixSolution {
    public String convert(String s, int nRows) {
        if ( s == null || nRows == 1 ) {
            return s;
        }
        int length = s.length();
        int unit = nRows + nRows -2;
        int num = length / unit;
        num = num + length % (2*nRows -2) > 0 ? 1 : 0;
        int column = num * unit;

        char[][] matrix = new char[nRows][column];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = ' ';
            }
        }

        char[] array = s.toCharArray();
        int row = 0;
        int col = 0;
        boolean direction = true;
        for (char c : array) {
            matrix[row][col] = c;
            if (direction) {
                row++;
            } else {
                row--;
                col++;
            }
            if (row == nRows) {
                row = nRows - 2;
                col++;
                direction = !direction;
            }
            if (row == 0) {
                direction = !direction;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows ; i++ ) {
            for ( int j = 0; j < column; j++) {
                if ( matrix[i][j] != ' ') {
                    sb.append(matrix[i][j]);
                }
            }
        }

        return sb.toString();
    }
}
