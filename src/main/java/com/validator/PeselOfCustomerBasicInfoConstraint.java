package com.validator;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Documented
@Constraint(validatedBy = PeselOfCustomerBasicInfoValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PeselOfCustomerBasicInfoConstraint {
    String message() default "musi być najpierw w bazie danych! Dodaj uzytkownika";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
