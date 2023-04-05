package com.casino.provide.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	/***
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	  public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        ex.getMessage(),
	        request.getDescription(false),
	        HttpStatus.NOT_FOUND.value());
	    
	    return message;
	  }
	
	@ExceptionHandler(InvalidSignatureError.class)
	  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	/***
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	  public ErrorMessage resourceNotFoundException(InvalidSignatureError ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        ex.getMessage(),
	        request.getDescription(false),
	        HttpStatus.UNAUTHORIZED.value());
	    
	    return message;
	  }
	
	@ExceptionHandler(Exception.class)
	  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	/***
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
	   
	    
	    ErrorMessage message = new ErrorMessage(
		        ex.getMessage(),
		        request.getDescription(false),
		        HttpStatus.INTERNAL_SERVER_ERROR.value());
	    
	    return message;
	  }
}
