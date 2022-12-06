package com.afs.employee.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(params ={""})
    public  Employee getById(@RequestParam Integer id){
        return null;
    }
}
