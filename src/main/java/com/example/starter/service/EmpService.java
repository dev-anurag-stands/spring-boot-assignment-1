package com.example.starter.service;

import java.util.*;
import com.example.starter.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    // Add an employee
    public String addEmployee(Employee employee) {
        if (employees.containsKey(employee.getEmployee_id())) {
            return "Employee with ID " + employee.getEmployee_id() + " already exists.";
        }
        employees.put(employee.getEmployee_id(), employee);
        return "Employee added successfully.";
    }

    // List all employees
    public List<Employee> listEmployees() {
        return new ArrayList<>(employees.values());
    }

    // Delete an employee by ID
    public String deleteEmployee(int employeeId) {
        if (employees.remove(employeeId) != null) {
            return "Employee deleted successfully.";
        } else {
            return "Employee with ID " + employeeId + " not found.";
        }
    }

    // Update an existing employee
    public String updateEmployee(int employeeId, String newName) {
        Employee employee = employees.get(employeeId);
        if (employee != null) {
            employee.setName(newName);
            return "Employee updated successfully.";
        } else {
            return "Employee with ID " + employeeId + " not found.";
        }
    }
}
