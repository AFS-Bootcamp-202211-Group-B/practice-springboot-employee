package com.afs.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Employee getByID(@PathVariable int id){
        return employeeRepository.findById(id);
    }
    @GetMapping(params = {"gender"})
    public List<Employee> getByGender(@RequestParam("gender") String gender){
        return employeeRepository.findByGender(gender);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.create(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        Employee existingEmployee = employeeRepository.findById(id);
        if(employee.getAge() != null){
            existingEmployee.setAge(employee.getAge());
        }
        if(employee.getAge() != null){
            existingEmployee.setSalary(employee.getSalary());
        }
        return existingEmployee;
    }
}
