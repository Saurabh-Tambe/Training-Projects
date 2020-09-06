package com.exception;

 

public class ProductNotFoundException extends Exception {
	
private String message;
	
	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public ProductNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		this.message = message;
		
	}
	
	public void displayMessage() {
		System.out.println(getMessage());
	}
	

}