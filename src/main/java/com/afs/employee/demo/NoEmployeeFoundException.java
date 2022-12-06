package com.afs.employee.demo;

public class NoEmployeeFoundException extends RuntimeException{
    public NoEmployeeFoundException(){
        super("No employee found.");
    }
}
