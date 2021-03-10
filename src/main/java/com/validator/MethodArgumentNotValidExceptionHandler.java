package com.validator;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;


@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {
    @ResponseStatus(NOT_ACCEPTABLE)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorWrapper MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);

    }

    public ErrorWrapper processFieldErrors(List<FieldError> fieldErrors) {
        ErrorWrapper errorWrapper = new ErrorWrapper("error.validation");
        for (FieldError fieldError : fieldErrors) {
            String[] fields = fieldError.getField().split("\\.");
            System.out.println(fields.length + " XDDDDDDDD ");
            errorWrapper.add(fieldError.getObjectName(), fieldError.getField(), (fields.length == 2 ? fields[1] : fields[0]) + " " + fieldError.getDefaultMessage());
        }
        return errorWrapper;
    }

}

