package com.ers.models;

import java.io.Serializable;

// To be able to write this to a file, we must mark it with the serializable interface

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean manager;
	private double pay;
	//private transient int ssn;
	
	
	
	
	public Employee() {
		super();
	}




	public Employee(String firstName, String lastName, String email, String password, boolean manager, double pay) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.manager = manager;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public boolean isManager() {
		return manager;
	}




	public void setManager(boolean manager) {
		this.manager = manager;
	}




	public double getPay() {
		return pay;
	}




	public void setPay(double pay) {
		this.pay = pay;
	}




	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", manager=" + manager + ", pay=" + pay + "]";
	}
	
	
	

}
