package com.redlabel.user.service.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("resource not found on server !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
