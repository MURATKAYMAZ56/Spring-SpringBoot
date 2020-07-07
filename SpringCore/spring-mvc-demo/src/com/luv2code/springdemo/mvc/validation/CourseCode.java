package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CourseConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//define default course code
	public String value( ) default"MRT";
	//define default error messages
	public  String message() default"must start with MRT";
	//define default groups
	public Class<?>[] groups() default {};
	
	//define default payloads .payloads provide details about validation failure(severity level, error code,etc)
	public Class<? extends Payload>[] payload() default {};
}
