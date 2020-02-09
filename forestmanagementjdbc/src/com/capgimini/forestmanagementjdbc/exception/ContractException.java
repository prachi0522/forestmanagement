package com.capgimini.forestmanagementjdbc.exception;

public class ContractException extends RuntimeException {
	String message;
	public ContractException() {
		
	}
	public  String InputMismatchException() {
		return super.getMessage();
	}
	public ContractException(String message){
		super();
		this.message=message;
	}
	 @Override
	public String getMessage() {
		return super.getMessage();
	}
}