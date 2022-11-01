package com.ers.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException {
	
	public EmployeeDoesNotExistException(){
		super("The employee you are searching for does not exist");
	}

}
