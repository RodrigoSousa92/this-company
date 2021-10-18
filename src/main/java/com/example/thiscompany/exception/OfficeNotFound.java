package com.example.thiscompany.exception;

public class OfficeNotFound extends RuntimeException {
    public OfficeNotFound() {super("Office not found.");}

    public OfficeNotFound(String message) {
        super(message);
    }
}
