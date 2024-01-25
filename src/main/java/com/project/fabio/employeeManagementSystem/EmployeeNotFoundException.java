package com.project.fabio.employeeManagementSystem;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Employee wasn't found in our database");
    }
}
