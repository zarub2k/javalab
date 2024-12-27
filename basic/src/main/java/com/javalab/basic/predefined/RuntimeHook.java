package com.javalab.basic.predefined;

/**
 * @author Tham
 */
public class RuntimeHook {
    public static void main(String[] args) {
        RuntimeHook runtimeHook = new RuntimeHook();
        Runtime runtime = Runtime.getRuntime();
        Thread thread = new Thread(runtimeHook::shutdown);
        runtime.addShutdownHook(thread);
        System.out.println("Ends");
    }

    private void shutdown() {
        System.out.println("Shutdown called");
    }
}
