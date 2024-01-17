package com.cbfacademy.restapiexercise.core;

public class IOUNotFoundException extends RuntimeException {
    public IOUNotFoundException(String message) {
        super(message);
    }
}
