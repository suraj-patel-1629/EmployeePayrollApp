package com.bridgelabz.employeepayroll.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}
