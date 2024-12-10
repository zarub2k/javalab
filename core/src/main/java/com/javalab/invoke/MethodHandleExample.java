package com.javalab.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
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
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        try {
            MethodHandle methodHandle = lookup.findVirtual(getClass(), "toString", methodType);
            Object invoke = methodHandle.invoke(this);
            System.out.println(invoke);
            System.out.println("Invoke is done");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
