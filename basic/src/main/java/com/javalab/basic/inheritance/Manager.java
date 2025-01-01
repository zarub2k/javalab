package com.javalab.basic.inheritance;

/**
 * @author Tham
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary) {
        super(name, salary);
        this.bonus = 0;
    }

    public Manager(String name, double salary, double bonus) {
        this(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
}
