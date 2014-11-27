package com.leohacker.leetcode.Archived.MinStack;

import java.util.Stack;

/**
 * Created by leojiang on 11/27/14.
 */
class MinStack {
    public void push(int x) {
        regularStack.push(x);
        if ( minStack.isEmpty() || x < minStack.peek() ) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        regularStack.pop();
        minStack.pop();
    }

    public int top() {
        return regularStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    private Stack<Integer> regularStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
}
