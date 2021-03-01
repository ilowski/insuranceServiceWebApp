package com.validator;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Documented
@Constraint(validatedBy = NumberOfPolicyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberOfPolicyConstraint {
    String message() default "jest już w bazie danych";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
