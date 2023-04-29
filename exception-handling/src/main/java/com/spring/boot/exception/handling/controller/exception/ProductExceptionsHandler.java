package com.spring.boot.exception.handling.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionsHandler{
	
	
	@ExceptionHandler(value = {ProductExceptionList.class})
    public ResponseEntity<Object> handleProductNotFoundException
            (ProductExceptionList productExceptionList)
    {
		ProductExceptions productException = new ProductExceptions(
				productExceptionList.getMessage(),
				productExceptionList.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(productException, HttpStatus.NOT_FOUND);
    }
}
