package com.nikolaiev.employeeservice;

import com.nikolaiev.employeeservice.entity.Employee;
import com.nikolaiev.employeeservice.factory.EmployeeFactory;
import com.nikolaiev.employeeservice.service.EmployeeService;

public class Test {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        EmployeeService employeeService = new EmployeeService(employeeFactory.generateEmployees(10));
        System.out.println("============calculateSalaryAndBonus=============");
        System.out.println(employeeService.calculateSalaryAndBonus());
        System.out.println("============getById=============");
        System.out.println(employeeService.getById(8));
        System.out.println("=============add============");
        employeeService.add(new Employee((long)employeeService.employees.length + 1,"Valya",20, 2000,'m'));
        System.out.println(employeeService.getByName("Valya"));
        System.out.println("=============remove============");
        System.out.println(employeeService.remove(11));
        System.out.println("=============edit============");
        System.out.println(employeeService.edit(new Employee(11,"Katya",21, 2000,'w')));
        System.out.println("=============getByName============");
        System.out.println(employeeService.getByName("Katya"));
        System.out.println("============sortByNameAndSalary=============");
        Employee[] employeesSorted = employeeService.sortByNameAndSalary();
        for (Employee employee : employeesSorted
             ) {
            System.out.println(employee.name + ",salary " + employee.salary + ". ");
        }
        System.out.println("");
        System.out.println("=========================");//сортирует только на убывание и не учитывает зп?
    }
}