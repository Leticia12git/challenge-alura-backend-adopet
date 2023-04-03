package com.alura.adopet.Adopet.exception;

import java.io.Serial;
import java.io.Serializable;

public class NotFoundException extends Exception  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

}