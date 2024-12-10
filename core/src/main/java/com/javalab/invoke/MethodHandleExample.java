package com.javalab.invoke;

import java.lang.invoke.MethodType;

/**
 * @author tham
 */
public class MethodHandleExample {
    public static void main(String[] args) {
        MethodHandleExample handleExample = new MethodHandleExample();
        handleExample.doMethodHandle();
    }

    private void doMethodHandle() {
        MethodType methodType = MethodType.methodType(String.class);
    }
}
