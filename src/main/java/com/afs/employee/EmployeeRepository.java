package com.afs.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    List<Employee> employees;

    public EmployeeRepository(){
        this.employees = new ArrayList<>();
        employees.add(new Employee(1, "Lily", 20, "Female", 8000));
        employees.add(new Employee(2, "A", 20, "Male", 8000));
        employees.add(new Employee(3, "B", 20, "Female", 8000));
        employees.add(new Employee(4, "C", 20, "Male", 8000));
    }
    public List<Employee> findAll() {
        return this.employees;
    }

    public Employee findById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    public List<Employee> findByGender(String gender) {
        return employees.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Employee create(Employee employee) {
        Integer id = generateNextId();
        employee.setId(id);
        employees.add(employee);
        return employee;
    }

    private Integer generateNextId() {
        int nextId = employees.stream()
                .mapToInt(employee -> employee.getId())
                .max()
                .orElse(1);
        return nextId + 1;
    }

    public void delete(Employee existingEmployee) {
        employees.remove(existingEmployee);
    }
}
