package com.validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorWrapper implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String message;
    private final String description;

    private List<FieldErrorDTO> fieldErrors;

    public ErrorWrapper(String message) {
        this(message, null);
    }

    public ErrorWrapper(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public ErrorWrapper(String message, String description, List<FieldErrorDTO> fieldErrors) {
        this.message = message;
        this.description = description;
        this.fieldErrors = fieldErrors;
    }

    public void add(String objectName, String field, String message) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }
        fieldErrors.add(new FieldErrorDTO(objectName, field, message));
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }
}
