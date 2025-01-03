package com.javalab.basic.inheritance;

/**
 * @author Tham
 */
public class InheritanceExample {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        Manager manager = new Manager("Tham", 10000.0, 1000.0);
        var employee1 = new Employee("Karl", 8000.0);
        Employee employee2 = new Employee("Roger", 5000.0);

        employees[0] = manager;
        employees[1] = employee1;
        employees[2] = employee2;

        for (Employee employee: employees) {
            System.out.println(employee.getName() + " > " + employee.getSalary());
        }

//        Manager newJoinee = (Manager) new Employee("", 0.0); //ERROR

        //manager.getSalary will always return the manager salary
        //declared type -> Employee / Actual type -> Manager
        //JVM calls the right method during the runtime
        // This process is called dynamic binding
        // Dynamic binding is the default behaviour in Java.
        // If you don't want, tag them as a final
    }
}
