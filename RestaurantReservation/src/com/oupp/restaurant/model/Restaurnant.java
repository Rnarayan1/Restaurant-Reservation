package com.oupp.restaurant.model;

public class Restaurnant {

	private String name;
	private String address;
	private String phoneNumber;
	private int capacity;
	private String email_id;
	private String password;
	private int numberOfTables;

	public int getNumberOfTables() {
		return numberOfTables;
	}

	public void setNumberOfTables(int numberOfTables) {
		this.numberOfTables = numberOfTables;
	}

	public Restaurnant() {

	}

	public Restaurnant(String name, String address, String phoneNumber, int capacity, String email_id,
			String password) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.capacity = capacity;
		this.email_id = email_id;
		this.password = password;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
