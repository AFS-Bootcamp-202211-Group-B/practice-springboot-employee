package com.afs.employee.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    List<Employee> employees;
    private int globalUniqueId=4;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee(1,"Lily",20,"Female",8000));
        employees.add(new Employee(2,"Lily2",20,"Female",8000));
        employees.add(new Employee(3,"Lily3",20,"Female",8000));
        employees.add(new Employee(4,"Lily4",20,"Female",8000));
    }

    public List<Employee> findAll(){
        return employees;
    }

    public Employee findEmployeeById(int id) {
        return employees.stream().filter(employee->employee.getId()==id).findFirst().get();
    }

    public List<Employee> findEmployeeByGender(String gender) {
        return employees.stream().filter(employee-> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Employee createEmployee(Employee newEmployee) {
        newEmployee.setId(generateNextId());
        employees.add(newEmployee);
        return newEmployee;
    }

    private Integer generateNextId() {
        return ++this.globalUniqueId;
    }

    public Employee updateEmployee(int id, Employee newEmployee) {
        Employee existingEmployee = findEmployeeById(id);
        if(newEmployee.getAge() != null){
            existingEmployee.setAge(newEmployee.getAge());
        }
        if(newEmployee.getSalary() != null){
            existingEmployee.setSalary(newEmployee.getSalary());
        }
        return existingEmployee;
    }

    public void deleteEmployee(int id) {
        this.employees =  employees.stream().filter(employee->employee.getId()!=id).collect(Collectors.toList());
    }
}
