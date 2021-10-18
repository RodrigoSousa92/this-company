package com.example.thiscompany.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super("Employee not found.");
    }

    public EmployeeNotFound(String message) {
        super(message);
    }
}

