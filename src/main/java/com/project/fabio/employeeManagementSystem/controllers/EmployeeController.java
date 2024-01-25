package com.project.fabio.employeeManagementSystem.controllers;

import com.project.fabio.employeeManagementSystem.models.Employee;
import com.project.fabio.employeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    private List<Employee> getEmployeesList() {
        return employeeService.getEmployeesList();
    }

    @GetMapping("/{id}")
    private Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    private Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    private Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    private void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
