package com.javalab.grounded;

/**
 * 1. avoid type casting
 * 2. pattern matching with record type (instance of)
 * 2. pattern matching with switch-case
 * 3. pattern matching enhancement with null case
 * 4. pattern matching with switch-case-when
 * 
 * @author Tham
 */
public class PatternMatchingExample {
    
    
    
    public static void main(String[] args) {
        PatternMatchingExample.patternMatchWithRecord(new Point(4, 6));
    }
    
    public static void instanceOfOld(Object value) {
        if (value instanceof String) {
            String name = (String) value;
            System.out.println("String value: " + name);
        } else {
            System.out.println("The input is NOT a string");
        }
    }
    
    // Type casting is not requied
    public static void instanceOfNew(Object value) {
        if (value instanceof String name) {
            System.out.println("String value: " + name);
        } else {
            System.out.println("The input is NOT a string");
        }
    }
    
    public static void instanceOfNewWithAnd(Object value) {
        if (value instanceof String name && !name.isEmpty()) {
            System.out.println("String value: " + name);
        } else {
            System.out.println("The input is NOT a string");
        }
    }
    
    public static void patternMatchWithRecord(Object object) {
        if (object instanceof Point(int x, int y)) {
            System.out.println("Point p1: (" + x + "," + y + ")");
        }
    }
    
    public static void patternMatchWithNestedRecord(Object object) {
        if (object instanceof Rectangle(Point p1, Point p2)) {
            System.out.println("Point p1: (" + p1.x() + "," + p1.y() + ")");
            System.out.println("Point p2: (" + p2.x() + "," + p2.y() + ")");
        }
    }
    
    public static void patternMatchWithDeepNestedRecord(Object object) {
        if (object instanceof Rectangle(Point (int x, int y), Point p2)) {
            System.out.println("Point p1: (" + x + "," + y + ")");
            System.out.println("Point p2: (" + p2.x() + "," + p2.y() + ")");
        }
    }
    
    public static void patternMatchWithSwitch(Object value) {
        switch (value) {
            case String s ->
                System.out.println("String type" + s.toUpperCase());
            case Integer i ->
                System.out.println("Integer type");
            case Long l ->
                System.out.println("Long type");
            default ->
                System.out.println("Not a defined type");
        }
    }
    
    public static void patternMatchWithSwitchAndNull(Object value) {
        switch (value) {
            case null ->
                System.out.println("Value is null");
            case String s ->
                System.out.println("String type");
            case Integer i ->
                System.out.println("Integer type");
            case Long l ->
                System.out.println("Long type");
            default ->
                System.out.println("Not a defined type");
        }
    }
    
    public static void patternMatchWithSwitchAndWhen(Object value) {
        switch (value) {
            case String s
                    when s.equalsIgnoreCase("YES") -> { System.out.println("Yes value"); }
            case String s
                    when s.equalsIgnoreCase("NO") -> { System.out.println("No value"); }
            case String s -> System.out.println("Neither 'YES' nor 'NO' ");
            case null, default -> System.out.println("Not the given type");
        }
    }
}
