package com.example.demo.service;

public class AuthorNotFoundException extends Throwable {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
