package com.biblioteca.elotech_api.exception;

public class BusinesException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinesException(String message) {
        super(message);
    }

    public BusinesException(Throwable cause) {
        super(cause);
    }

    public BusinesException(String message, Throwable cause) {
        super(message, cause);
    }
}
