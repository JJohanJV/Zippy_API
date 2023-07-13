package com.zippy.api.exception;

public class TripNotFoundException extends RuntimeException{
    public TripNotFoundException(String message) {
        super(message);
    }
}
