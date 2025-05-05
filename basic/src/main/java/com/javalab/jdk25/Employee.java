package com.javalab.jdk25;

/**
 *
 * @author Tham
 */
public class Employee extends Person {
    String officeId;
    public Employee(String name, int age, String officeId) {
        if (age <= 18) {
            throw new IllegalArgumentException("Age should be > 18");
        }
        
        super(name, age);
        this.officeId = officeId;
    }
}
