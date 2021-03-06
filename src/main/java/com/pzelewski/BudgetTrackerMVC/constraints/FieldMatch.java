package com.pzelewski.BudgetTrackerMVC.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.pzelewski.BudgetTrackerMVC.constraints.impl.FieldMatchValidator;

/**
 * Annotation to validate 2 fields have the same value.
 * 
 * Example:
 *@FieldMatch.List({
 *	@FieldMatch(first="userPassword", second="userConfirmPassword", message="The password fields must match."),
 *	@FieldMatch(first="userEmail", second="userConfirmEmail", message="The e-mail fields must match.")})
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {
	
	String message() default "{constraints.fieldmatch}";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String first();
	
	String second();
	
	@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
		@interface List
		{
		FieldMatch[] value();
		}

}
