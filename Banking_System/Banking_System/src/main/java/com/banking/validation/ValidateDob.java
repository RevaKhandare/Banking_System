package com.banking.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DobValidator.class)

public @interface ValidateDob {
    public String message() default "Age should be 20 or greater than 20 years";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}

