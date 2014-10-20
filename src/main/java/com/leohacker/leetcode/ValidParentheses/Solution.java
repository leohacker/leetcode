package com.leohacker.leetcode.ValidParentheses;

import java.util.Stack;

/**
 * Created by leojiang on 10/20/14.
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }

        int len = s.length();
        boolean broken = false;
        int i = 0;
        Stack<Character> stack = new Stack<Character>();

        while (i < len && !broken) {
            char c = s.charAt(i);
            if (c == '}' || c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    broken = true;
                } else {
                    char top = stack.pop();
                    if (top != matchParen(c)) {
                        broken = true;
                    }
                }
            } else {
                stack.push(c);
            }
            i++;
        }
        return !broken && stack.isEmpty();
    }

    private char matchParen(char c) {
        switch (c) {
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }
}
