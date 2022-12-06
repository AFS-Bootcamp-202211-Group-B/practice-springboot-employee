package com.afs.employee.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public Employee getEmployeeById(@PathVariable int id){
        return employeeRepository.findEmployeeById(id);
    }

    @GetMapping(params = {"gender"})
    public List<Employee> getEmployeeByGender(@RequestParam String gender){
        return employeeRepository.findEmployeeByGender(gender);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee newEmployee){

        return employeeRepository.createEmployee(newEmployee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee newEmployee){
        return employeeRepository.updateEmployee(id,newEmployee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id){
        employeeRepository.deleteEmployee(id);
    }


}
