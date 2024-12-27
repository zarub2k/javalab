package com.javalab.basic.predefined;

/**
 * @author Tham
 */
public class RecordExample {
    public static void main(String[] args) {
        Point point = new Point(3, 5);
        double distance = point.distanceFromOrigin();
        System.out.println(distance);
    }
}
