package com.cbfacademy.restapiexercise.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiErrorResponse {
    private final String message;

    @JsonCreator
    public ApiErrorResponse(@JsonProperty("message") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
