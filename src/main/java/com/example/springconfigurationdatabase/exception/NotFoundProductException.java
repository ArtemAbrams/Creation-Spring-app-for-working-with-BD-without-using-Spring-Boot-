package com.example.springconfigurationdatabase.exception;

public class NotFoundProductException extends RuntimeException {
    public NotFoundProductException(){
        super("Not Found Product");
    }
}
