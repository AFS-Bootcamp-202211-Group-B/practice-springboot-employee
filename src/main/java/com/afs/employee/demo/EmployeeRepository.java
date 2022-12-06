package com.afs.employee.demo;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
                .filter(employee -> employee.getId()==id)
                .findFirst()
                .orElseThrow(NoEmployeeFoundException::new);
    }
    public Employee create(Employee employee){
        employee.setId(generateNextId());
        employees.add(employee);
        return employee;
    }

    public Employee update(Integer id, Employee employee){
        Employee existingEmployee = findById(id);
        if (employee.getAge() != null) existingEmployee.setAge(employee.getAge());
        if (employee.getSalary() != null) existingEmployee.setSalary(employee.getSalary());
        return existingEmployee;
    }

    public Employee delete(Integer id){
        Employee existingEmployee = findById(id);
        employees.remove(existingEmployee);
        return existingEmployee;
    }
    private Integer generateNextId(){
        int nextId = employees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(1);
        return nextId + 1;
    }

    public List<Employee> pageQuery(Integer page, Integer pageSize){
        return employees.subList(page - 1, page - 1 + pageSize);
    }

    public List<Employee> findByGender(String gender){
        return employees.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }
}
