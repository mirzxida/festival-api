package com.example.festival.exceptions;
import com.example.festival.exceptions.InvalidSlotException;
import com.example.festival.exceptions.TimeCollisionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidSlotException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidSlot(InvalidSlotException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", "INVALID_INPUT",
                        "message", e.getMessage()
                ));
    }

    @ExceptionHandler(TimeCollisionException.class)
    public ResponseEntity<Map<String, Object>> handleTimeCollision(TimeCollisionException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of(
                        "error", "TIME_COLLISION",
                        "message", e.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAny(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "error", "SERVER_ERROR",
                        "message", e.getMessage()
                ));
    }
}
