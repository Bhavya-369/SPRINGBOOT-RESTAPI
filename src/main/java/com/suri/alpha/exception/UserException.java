package com.suri.alpha.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserException {
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		
		
		Map<String,String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
		.forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		
	}
	
	 @ExceptionHandler(DuplicateUserException.class)
	    public ResponseEntity<String> handleDuplicateUser(DuplicateUserException ex) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	    }
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundExceptions(
			ResourceNotFoundException ex){
		
		
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		
	}

}
