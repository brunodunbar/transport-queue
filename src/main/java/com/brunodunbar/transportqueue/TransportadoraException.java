package com.brunodunbar.transportqueue;

public class TransportadoraException extends Exception {

    public TransportadoraException() {
    }

    public TransportadoraException(String message) {
        super(message);
    }

    public TransportadoraException(String message, Throwable cause) {
        super(message, cause);
    }
}
