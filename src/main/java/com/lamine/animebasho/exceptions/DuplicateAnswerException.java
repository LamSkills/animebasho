package com.lamine.animebasho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateAnswerException extends RuntimeException {

    public DuplicateAnswerException(String message) {
        super(message);
    }
}
