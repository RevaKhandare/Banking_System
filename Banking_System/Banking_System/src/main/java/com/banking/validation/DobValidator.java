package com.banking.validation;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DobValidator implements ConstraintValidator<ValidateDob,Date>{

    @Override
    public boolean isValid(Date dob, ConstraintValidatorContext context) {
        
//          Date currentDate = null; 
//          SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");                           
//          int d1 = Integer.parseInt(formatter.format(dob));                            
//          int d2 = Integer.parseInt(formatter.format(currentDate));                          
//          int age = (d2 - d1) / 10000;   
//          //int Age = Period.between(dob, currentDate).getYears();
//          if(age >= 20) {
//              return true;
//              
//          }
//          return false;
//       
        
        
        
          if(dob == null) {
              return false;
          }
          
//          LocalDate birthDate = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
          LocalDate birthDate = dob.toLocalDate();
          LocalDate now = LocalDate.now();
          int age = Period.between(birthDate, now).getYears();
          return age >= 20;
          //return Period.between(birthDate, LocalDate.now()).getYears()>= 20;
          
          
            
          
    
        
        
    
    
    
    }
    

}