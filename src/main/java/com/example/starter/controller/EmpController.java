package com.example.starter.controller;

import com.example.starter.model.Employee;
import com.example.starter.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World!";
    }

    // Add a new employee
    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        return empService.addEmployee(employee);
    }

    // List all employees
    @GetMapping
    public List<Employee> listEmployees() {
        return empService.listEmployees();
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        return empService.deleteEmployee(id);
    }

    // Update an employee's name
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable("id") int id, @RequestBody Employee updatedEmployee) {
        return empService.updateEmployee(id, updatedEmployee.getName());
    }
}
