package com.library.LibraryManagementSystem.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserException extends RuntimeException {

    private HttpStatus status;

    public UserException(String message, HttpStatus status){
        super(message);
        this.status=status;
    }

}
