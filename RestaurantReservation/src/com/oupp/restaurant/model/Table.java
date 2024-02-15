package com.oupp.restaurant.model;

public class Table {

	int id;
	int capacity;
	boolean available;

	public Table() {
	}

	public Table(int id, int capacity, boolean available) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
