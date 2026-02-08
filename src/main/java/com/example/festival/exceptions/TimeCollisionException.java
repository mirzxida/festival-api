package com.example.festival.exceptions;

public class TimeCollisionException extends RuntimeException {
    public TimeCollisionException(String msg) {
        super(msg);
    }
}
