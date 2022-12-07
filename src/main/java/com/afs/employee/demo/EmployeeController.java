package com.afs.employee.demo;


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
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeRepository.findEmployeeById(id);
    }
//    @GetMapping(params = {""})

    @GetMapping(params = {"gender"})
    public List<Employee> getEmployeeByGender(@RequestParam String gender){
        return employeeRepository.findEmployeeByGender(gender);
    }

    // POST /employees
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.create(employee);
    }

    @PutMapping({"/{id}"})
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        return employeeRepository.update(id, employee);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable  Integer id){
         employeeRepository.delete(id);
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<Employee> getEmployeeByGender(@RequestParam int page, int pageSize){
        return employeeRepository.queryPage(page, pageSize);
    }

}
