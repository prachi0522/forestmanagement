package com.capgimini.forestmanagementjdbc.exception;

public class ProductException extends RuntimeException {
String message;
	
	public ProductException(){	
	}
	public ProductException(String message) {
		super();
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}