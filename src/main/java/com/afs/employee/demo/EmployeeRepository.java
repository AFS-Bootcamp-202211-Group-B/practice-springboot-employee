package com.afs.employee.demo;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    List<Employee> employees;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee("1", "Jason", 18, "male", 50000));
        employees.add(new Employee("1", "Vincent", 8, "male", 50000));

    }

    public List<Employee> findAll() {
        return employees;
    }
}
