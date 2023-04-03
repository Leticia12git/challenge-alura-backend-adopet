package com.alura.adopet.Adopet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Classe de excessão de validação
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends Exception implements Serializable {

    public ValidationException(String message) {
        super(message);
    }
}
