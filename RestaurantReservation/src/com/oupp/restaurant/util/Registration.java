package com.oupp.restaurant.util;

public class Registration {

	private String name;
	private String address;
	private String phNo;
	private String email;
	private String password;
	private int capacity;
	private int numberOfTables;

	public int getNumberOfTables() {
		return numberOfTables;
	}

	public void setNumberOfTables(int numberOfTables) {
		this.numberOfTables = numberOfTables;
	}

	public Registration() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Registration(String name, String address, String phNo, String email, String password, int capacity) {
		super();
		this.name = name;
		this.address = address;
		this.phNo = phNo;
		this.email = email;
		this.capacity = capacity;
	}

	public Registration(String name, String address, String phNo, String email, String password) {
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", address=" + address + ", phNo=" + phNo + ", email=" + email
				+ ", password=" + password + ", capacity=" + capacity + ", numberOfTables=" + numberOfTables + "]";
	}

}
