package com.javalab.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author tham
 */
public class ThreeTypeAccess {
    public static void main(String[] args) {
        ThreeTypeAccess instance = new ThreeTypeAccess();
//        instance.doReflective();
        instance.doMethodHandle();
    }

    //Private method access by setting setAccessible to true
    public void doReflective() {
        Method method = null;

        Class<?>[] args = new Class[] {Void.class};
        try {
            method = ThreeTypeAccess.class
                    .getDeclaredMethod("privateMethod", args);
            method.setAccessible(true);
            method.invoke(this, null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void privateMethod() {
        System.out.println("Private method called");
//        return true;
    }

    //Private method access through proxy
    public static class Proxy {
        private Proxy() {}
        public static void invoke(ThreeTypeAccess instance) {
            instance.privateMethod();
        }
    }

    //Private method access through Method handle
    public void doMethodHandle() {
        MethodType methodType = MethodType.methodType(void.class); //boolean.class when no return value in the method
        try {
            MethodHandle methodHandle = MethodHandles.lookup()
                    .findVirtual(ThreeTypeAccess.class, "privateMethod", methodType);
            methodHandle.invoke(this);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
