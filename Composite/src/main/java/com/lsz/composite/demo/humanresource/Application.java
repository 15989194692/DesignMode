package com.lsz.composite.demo.humanresource;

public class Application {
    public static void main(String[] args) {
        Department department = new Department(1);
        department.addHumanResource(new Employee(11, 11));
        department.addHumanResource(new Employee(12, 12));

        Department department1 = new Department(2);
        department1.addHumanResource(new Employee(21, 21));
        department1.addHumanResource(new Employee(22, 22));

        department.addHumanResource(department1);

        System.out.println(department.calculateSalary());
        System.out.println(department1.calculateSalary());
    }
}
