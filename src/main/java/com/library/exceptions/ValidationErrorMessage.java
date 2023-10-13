package com.library.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationErrorMessage extends ErrorMessage {
    List<String> errors;

    public ValidationErrorMessage(int statusCode, Instant timestamp, List<String> errors) {
        super(statusCode, timestamp);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
