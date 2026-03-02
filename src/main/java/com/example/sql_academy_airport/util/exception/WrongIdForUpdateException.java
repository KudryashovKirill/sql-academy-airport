package com.example.sql_academy_airport.util.exception;

public class WrongIdForUpdateException extends RuntimeException {
    public WrongIdForUpdateException(String message) {
        super(message);
    }
}
