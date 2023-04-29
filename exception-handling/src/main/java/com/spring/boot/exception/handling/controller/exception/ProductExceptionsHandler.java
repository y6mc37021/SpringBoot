package com.spring.boot.exception.handling.controller.exception;

public class ProductExceptionsHandler extends RuntimeException{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7586886526557189847L;

	public ProductExceptionsHandler(String message) {
        super(message);
    }

    public ProductExceptionsHandler(String message, Throwable cause) {
        super(message, cause);
    }

}
