package com.javalab.ds;

import java.util.Stack;

/**
 * @author Tham
 */
public class StackPerformance {
    public static void main(String[] args) {
        StackPerformance stackPerformance = new StackPerformance();
        stackPerformance.doSimpleStack();
    }

    private void doSimpleStack() {
        Stack<Integer> numberStack = new Stack<>();
        for (int i = 0; i < 10; i = i + 2) {
            numberStack.push(i);
        }

        System.out.println("before: " + numberStack);
        System.out.println(numberStack.pop());
        System.out.println(numberStack.pop());
        System.out.println("after: " +numberStack);
    }
}
