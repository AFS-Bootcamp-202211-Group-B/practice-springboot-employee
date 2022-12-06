package com.afs.employee.demo;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    List<Employee> employees;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee(1, "Jason", 18, "male", 50000));
        employees.add(new Employee(2, "Vincent", 8, "male", 50000));

    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(Integer id){
        return employees.stream()
                .filter(employee -> employee.getId().equals(id.toString()))
                .findFirst()
                .orElseThrow(NoEmployeeFoundException::new);
    }
//    public Employee create(Employee employee){
//        Integer
//    }
    private Integer generateNextId(){
        int nextId = employees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(1);
        return nextId + 1;
    }


    public List<Employee> findByGender(String gender){
        return employees.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }
}
