package com.project.fabio.employeeManagementSystem.services;

import com.project.fabio.employeeManagementSystem.EmployeeNotFoundException;
import com.project.fabio.employeeManagementSystem.interfaces.EmployeeRepository;
import com.project.fabio.employeeManagementSystem.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesList() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeOptional = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
        List<Employee> employeeList = this.getEmployeesList();
        employeeList
                .stream()
                .filter(listEmployee -> Objects.equals(listEmployee.getId(), id))
                .map(listEmployee -> {
                    listEmployee.setFirstName(employee.getFirstName());
                    listEmployee.setLastName(employee.getLastName());
                    listEmployee.setEmail(employee.getEmail());
                    return listEmployee;
                });
        return employee;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
