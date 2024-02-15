
package com.oupp.restaurant.model;

import java.util.Date;


public class Reservation {

	private int reserveId;
	private String reserveDate;
	private String reserveTime;
	private int reservePartySize;
	private String reserveCustomerName;
	private String reservePhoneNumber;
	private int reserveTableId;

	public Reservation() {

	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public Reservation(int reserveId, String reserveDate, String reserveTime, int reservePartySize,
			String reserveCustomerName, String reservePhoneNumber, int reserveTableId) {
		super();
		this.reserveId = reserveId;
		this.reserveDate = reserveDate;
		this.reserveTime = reserveTime;
		this.reservePartySize = reservePartySize;
		this.reserveCustomerName = reserveCustomerName;
		this.reservePhoneNumber = reservePhoneNumber;
		this.reserveTableId = reserveTableId;
	}

	public int getReservePartySize() {
		return reservePartySize;
	}

	public void setReservePartySize(int reservePartySize) {
		this.reservePartySize = reservePartySize;
	}

	public String getReserveCustomerName() {
		return reserveCustomerName;
	}

	public void setReserveCustomerName(String reserveCustomerName) {
		this.reserveCustomerName = reserveCustomerName;
	}

	public String getReservePhoneNumber() {
		return reservePhoneNumber;
	}

	public void setReservePhoneNumber(String reservePhoneNumber) {
		this.reservePhoneNumber = reservePhoneNumber;
	}

	public int getReserveTableId() {
		return reserveTableId;
	}

	public void setReserveTableId(int reserveTableId) {
		this.reserveTableId = reserveTableId;
	}

	
}
