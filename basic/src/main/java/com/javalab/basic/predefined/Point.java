package com.javalab.basic.predefined;

//Canonical constructor with all the parameters
public record Point(double x, double y) {

    //Compact constructor without any parameters - normalize
    public Point {
        if (x < 0) {
            x = 0;
        } else if (y < 0) {
            y = 0;
        }
    }

    //Validating style
    /*public Point {
        if (x < 0 && y < 0) {
            throw new IllegalArgumentException("X and Y should not be lesser than zero");
        }
    }*/

    //Custom constructor
    public Point() {
        this(0, 0);
    }


    public double distanceFromOrigin() {
        return Math.hypot(x, y);
    }
}
