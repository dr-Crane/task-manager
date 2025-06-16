package com.example.task.manager.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer id) {
        super("There's no user with ID = " + id);
    }

}
