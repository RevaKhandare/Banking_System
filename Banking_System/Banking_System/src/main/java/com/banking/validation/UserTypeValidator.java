package com.banking.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserTypeValidator implements ConstraintValidator<UserTypeValidation,String> {

    @Override
    public boolean isValid(String user_type, ConstraintValidatorContext context) {
        
        List<String> user_type_list = Arrays.asList("Customer","Bank Staff");
        
        return user_type_list.contains(user_type);
    }

}