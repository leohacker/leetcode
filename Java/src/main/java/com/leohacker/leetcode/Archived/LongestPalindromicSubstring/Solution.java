package com.leohacker.leetcode.Archived.LongestPalindromicSubstring;

/**
 suppose

 string(i,l) is a substring of s where i is the start index and l is the length

 S(n) is the longest palindrome for substring of s with indice from 0 to n
 if S(n-1) = string(i,l)

 then S(n) =

 string(n-l, l+1) if string(n-l, l+1) is palindrome
 string(n-l-1, l+2) if string(n-l-1, l+2) is palindrome
 S(n-1) otherwise
 */
public class Solution {
    public String longestPalindrome(String s) {
        int i = 0;
        int l = 0;
        int n = s.length();
        for(int j=0;j<n;j++){
            if(isPalindrome(s, j-l, j)){
                i = j-l;
                l = l+1;
            }else if(j-l-1>=0 && isPalindrome(s, j-l-1, j)){
                i = j-l-1;
                l = l+2;
            }
        }

        return new String(s.getBytes(), i, l);
    }

    private boolean isPalindrome(String s, int start, int end) {
        String subs = s.substring(start, end+1);
        StringBuilder sb = new StringBuilder(subs);

        return sb.reverse().toString().equals(subs);
    }
}
