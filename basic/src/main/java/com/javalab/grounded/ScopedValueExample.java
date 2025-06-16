package com.javalab.grounded;

import static java.lang.ScopedValue.where;

/**
 *
 * @author Tham
 */
public class ScopedValueExample {
    private static final ScopedValue<String> context = ScopedValue.newInstance();
    public static void main(String[] args) {
        where(context, "HelloTham").run(() -> callInsideScope());
        callOutsideScope();
    }
    
    private static void callInsideScope() {
        System.out.println("Inside scope call");
        System.out.println("Scoped value: " + context.get());
    }
    
    private static void callOutsideScope() {
        System.out.println("Outside scope call");
        System.out.println("Scoped value: " + context.get());
    }
    
}
