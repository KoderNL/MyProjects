package com.nikolaiev.employeeservice.entity;

public class Employee {
    public long id;
    public String name;
    public int age;
    public int salary;
    public char gender;
    public Employee(long id, String name, int age, int salary, char gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }
}
/* Documentation

*/