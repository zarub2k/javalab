package com.javalab.gc;

public class HelloClass {
    private String name;
    HelloClass ref;

    public HelloClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("HelloClass finalize()");
        super.finalize();
    }
}
