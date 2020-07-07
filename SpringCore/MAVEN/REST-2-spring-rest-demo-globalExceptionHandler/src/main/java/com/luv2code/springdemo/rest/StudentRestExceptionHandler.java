package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	
	//add exception handler 
	
	
	// Add an exceptional handeler using 

		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

			// create a StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMassage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return ResponseEntity

			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		}
		// here the problem was What if the user enter a letter instead of numeric

		// Add another Exception Handeler

		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
			
			
			// create a StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMassage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return ResponseEntity

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		}

}
