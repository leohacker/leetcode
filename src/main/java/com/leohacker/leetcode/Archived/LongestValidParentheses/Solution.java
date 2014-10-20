package com.leohacker.leetcode.Archived.LongestValidParentheses;

/**
 * 基本的思路是每次遇到右括号，就开始处理前面未处理的左括号。
 *
 * 考虑()这种情况，右括号的出现就吃掉一个左括号，当前长度是2。如果是(())这种情况，在出现第一个右括号的时候，处理的结果是(2。
 * 这时处理下一个右括号的时候，吃掉左括号，将当前长度加2。这样，一边扫描字符串的过程，就是将左括号和中间结果压栈，出现右括号弹栈的过程。
 * 我们就可以用一个栈来存储未处理的数据。
 *
 * 简化吃括号这个动作，我们可以不将最后出现的当前长度放入栈内。这样每次栈顶都是左括号。
 * 对于()(()这样的例子，未处理的数据是2(2。所以有将计算中的长度压栈的需要。
 * 本来栈应该存放数字和字母的组合，简化实现，将左括号存为1。
 *
 * 由于可能到最后都没有出现可匹配的右括号，所以最后栈中可能还有未处理的数据。
 * 所以在最后要扫描一边栈，找出可能的最大长度。不要忘记还有不在栈里面的当前长度。
 *
 * 如果栈中数据被吃完，就计算出一段字符串的结果，就可以计算局部的最大长度。
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if ( s == null ) {
            return 0;
        }
        int len = s.length();

        // give the result ASAP.
        if (len == 0 || len == 1) {
            return 0;
        }

        // Use the stack to store the incomplete data. The max size for stack is the length of string.
        int[] stack = new int[len];
        int index = 0;              // the pointer to stack.
        int currentLength = 0;      // the current length for right-most valid parentheses.
        int maxLength = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if ( c == '(') {
                // if current length exists, push the current length into stack.
                if ( currentLength > 0 ) {
                    stack[index] = currentLength;
                    index++;
                }
                // push the left parentheses into stack.
                stack[index] = 1;
                index++;
                // reset the current length since the left parentheses appears and interrupt the continuation.
                currentLength = 0;
            } else if ( index == 0 ) {
                // index == 0 means that we have eaten all left parentheses, orphan right parentheses.
                // calculate the max length and current length.
                maxLength = ( maxLength > currentLength ) ? maxLength : currentLength ;
                // reset current length since the orphan parentheses interrupt the continuation.
                currentLength = 0;
            } else {
                // eat the current left parentheses
                // decrease the index first since the index point to the next empty slot after last element.
                index--;                // popup the last left parentheses.
                currentLength += 2;     // add the current length.
                // merge the previous length number.
                if ( index > 0 && stack[index-1] != 1 ) {    // if the previous slot is not left parentheses.
                    index--;
                    currentLength += stack[index];
                }
            }
        }

        // scan the stack and calculate the max length.
        for (int i = 0; i < index; i++) {
            if ( stack[i] != 1 ) {
                maxLength = ( maxLength > stack[i]) ? maxLength : stack[i];
            }
        }

        // don't forgot the current length.
        maxLength = ( maxLength > currentLength ) ? maxLength : currentLength ;
        return maxLength;
    }
}
