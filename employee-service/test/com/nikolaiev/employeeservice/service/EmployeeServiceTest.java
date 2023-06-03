package com.nikolaiev.employeeservice.service;

import com.nikolaiev.employeeservice.entity.Employee;
import com.nikolaiev.employeeservice.factory.EmployeeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {
    EmployeeFactory employeeFactory = new EmployeeFactory();
    EmployeeService employeeService = new EmployeeService(employeeFactory.generateEmployees(10));
    @Test
    public void testGetByName() {
        String expected = employeeService.employees[1].name;
        Employee actualObject = employeeService.getByName(employeeService.employees[1].name);
        assertEquals(expected,actualObject.name);
    }
    @Test
    public void testGetById() {
        long expected = 5;
        Employee actualObject = employeeService.getById(5);
        long actual = actualObject.id;
        assertEquals(expected,actual);
    }
}
