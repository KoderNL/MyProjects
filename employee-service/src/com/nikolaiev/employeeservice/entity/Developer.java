package com.nikolaiev.employeeservice.entity;

import java.util.Random;
public class Developer extends Employee {
    public int fixedBugs;
    Random random = new Random();
    public Developer (long id, String name, int age, int salary, char gender, int fixedBugs) {
        super(id, name, age, salary, gender);
        this.fixedBugs = fixedBugs;
    }
    public double fullSalary(int salary) {
        boolean randomBoolean = random.nextBoolean();
        return (salary + fixedBugs * 2) * (randomBoolean ? 2 : 0);
    }
}


