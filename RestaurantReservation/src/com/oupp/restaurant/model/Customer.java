package com.oupp.restaurant.model;

public class Customer {

	private String name;
	private String address;
	private String phNo;
	private String email;
	private String password;
	
	public Customer(){
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(String name, String address, String phNo, String email) {
		super();
		this.name = name;
		this.address = address;
		this.phNo = phNo;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
