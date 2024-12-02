package com.javalab.concurrency;

/**
 * @author tham
 */
public class StringStack {
    private final String[] values = new String[16];
    private int index = 0;

    public boolean push(String s) {
        if (index < values.length) {
            values[index] = s;
            index = index + 1;

            return true;
        }

        return false;
    }

    public String pop() {
        if (index < 1) {
            return null;
        }

        index = index - 1;
        return values[index];
    }

    public static void main(String[] args) {
        StringStack stringStack = new StringStack();
        stringStack.push("Tham");
        stringStack.push("Roger");

        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());

        stringStack.push("Rafa");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
    }
}
