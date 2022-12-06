package com.afs.employee.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    List<Employee> employees;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee(1, "Lily", 20, "Female", 8000));
        employees.add(new Employee(1, "Lucy", 21, "Female", 8000));
        employees.add(new Employee(1, "Poyo", 20, "Male", 8000));
    }

    public List<Employee> findAll() {
        return employees;
    }
}
