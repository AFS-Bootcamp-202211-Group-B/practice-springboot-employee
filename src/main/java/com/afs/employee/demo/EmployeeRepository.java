package com.afs.employee.demo;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    List<Employee> employees;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee("1", "Jason", 18, "male", 50000));
        employees.add(new Employee("2", "Vincent", 18, "male", 50000));

    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(Integer id) throws NoEmployeeFoundException {

        return employees.stream()
                .filter(employees -> employees.getId().equals(id.toString()))
                .findFirst()
                .orElseThrow(NoEmployeeFoundException::new);

    }

    public Employee findGender(String gender)  throws NoEmployeeFoundException{

        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getGender().equals(gender)) {
                list.add(employee);
            }
        }
        return (Employee) list;

    }
}
