package com.ayigroup.mepv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserNameNotAvailableException extends IllegalStateException {

    public UserNameNotAvailableException(String message) {
        super(message);
    }
}
