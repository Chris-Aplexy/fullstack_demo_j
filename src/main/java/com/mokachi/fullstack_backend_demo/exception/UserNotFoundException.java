package com.mokachi.fullstack_backend_demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("user not found of id " + id);
    }
}
