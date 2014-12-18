package com.leohacker.leetcode.Archived.PalindromeNumber;

/**
 * Better if we can use an array to store the mod number.
 * Now I have to get the n-mod number, so divide the number again and again.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if ( x < 0 ) {
            return false;
        }
        if ( x == 0 ) {
            return true;
        }
        int bits = bits(x);
        int index = 1;
        while ( bits - index + 1 > index ) {
            int left = modn(x, bits - index + 1);
            int right = modn(x, index);
            if ( left != right ) {
                return false;
            }
            index++;
        }
        return true;
    }

    private int bits(int x) {
        int bits = 0;
        while ( x > 0 ) {
            x = x / 10;
            bits++;
        }
        return bits;
    }

    // get the n-th mod num.
    private int modn(int x, int n) {
        int num = 0;
        while ( n > 0 ) {
            num = x % 10;
            x = x / 10;
            n--;
        }
        return num;
    }
}
