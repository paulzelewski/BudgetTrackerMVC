package com.pzelewski.BudgetTrackerMVC.constraints.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import com.pzelewski.BudgetTrackerMVC.constraints.FieldMatch;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	
	private String firstFieldName;
	private String secondFieldName;
	private String message;
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		boolean valid = true;
		
		final Object firstObj = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
		final Object secondObj = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);
			
		valid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
				
		if(!valid) {
			
			context.buildConstraintViolationWithTemplate(message)
		  		.addPropertyNode(firstFieldName)
		  		.addConstraintViolation()
		  		.disableDefaultConstraintViolation();
		  	context.buildConstraintViolationWithTemplate(message)
		  		.addPropertyNode(secondFieldName)
		  		.addConstraintViolation()
		  		.disableDefaultConstraintViolation();				
		}
		
		return valid;
		 
	}
	

}
