package com.javalab.basic.predefined;

public record Point(double x, double y) {
    public double distanceFromOrigin() {
        return Math.hypot(x, y);
    }
}
