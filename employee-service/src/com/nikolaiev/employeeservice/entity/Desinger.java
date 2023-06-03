package com.nikolaiev.employeeservice.entity;

public class Desinger extends Employee {
    public int rate;
    public int workedDays;
    public Desinger(long id, String name, int age, int salary, char gender, int rate, int workedDays) {
        super(id, name, age, salary, gender);//parents class statements
        this.rate = rate;//unique statement
        this.workedDays = workedDays;//unique statement
    }//constructor call for make new object of this class
    public double fullSalary(int salary) {//method of class
        return salary + (rate * workedDays);
    }
}
