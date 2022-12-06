package com.afs.employee.demo;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/employees")


public class EmployeeController {

    private EmployeeRepository  employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping
    public List<Employee> getAll(){

        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) throws NoEmployeeFoundException {
        return employeeRepository.findById(id);
    }

    @GetMapping(params = {"/{gender}"})
    public Employee getEmployeesByGender(@RequestParam String gender) throws NoEmployeeFoundException{
        return employeeRepository.findGender(gender);
    }
}
