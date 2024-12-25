package com.javalab.basic.controlflow;

/**
 * @author Tham
 */
public class SwitchExample {
    enum Shape {Circle, Square, Triangle}

    public void switchExpression(Shape shape) {
        String shapeName = switch (shape) {
            case Square -> {
                yield "This is a square";
            }
            case Circle -> "This is a square";
            case Triangle -> "This is a triangle";
            case null -> throw new IllegalArgumentException("Not a proper shape");
        };

        System.out.println(shapeName);
    }

    public void normalSwitch(Shape shape) {
        String shapeName = "";
        switch (shape) {
            case Circle:
                shapeName = "This is a circle";
                break;
            case Square:
                shapeName = "This is a square";
                break;
            case Triangle:
                shapeName = "This is a triangle";
                break;
            case null:
                System.out.println("Bad shape");
        }

        System.out.println(shapeName);
    }
}
