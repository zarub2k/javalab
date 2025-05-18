package com.javalab.grounded;

/**
 * 1. avoid type casting
 * 2. pattern matching with switch-case
 * 3. pattern matching enhancement with null case
 * 4. pattern matching with switch-case-when
 * 
 * @author Tham
 */
public class PatternMatchingExample {
    public static void main(String[] args) {
        
//        PatternMatchingExample.testString("YES");
        
        PatternMatchingExample.instanceOfNew(Integer.valueOf("2"));
        PatternMatchingExample.instanceOfNew("Tham");
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
    
    public static void testString(Object value) {
        switch (value) {
            case null -> { System.out.println("The input is null"); }
            case String s
                    when s.equalsIgnoreCase("YES") -> { System.out.println("Yes value"); }
            case String s
                    when s.equalsIgnoreCase("NO") -> { System.out.println("No value"); }
            case String s -> System.out.println("Not an expected input");
            default -> System.out.println("Not the given type");
        }
    }
}
