package com.spring.boot.exception.handling.controller.exception;

public class ProductExceptionList extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6606054606849320244L;

	public ProductExceptionList(String message) {
        super(message);
    }

    public ProductExceptionList(String message, Throwable cause) {
        super(message, cause);
    }
}
