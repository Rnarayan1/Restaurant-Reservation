package com.oupp.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.oupp.restaurant.model.Reservation;
import com.oupp.restaurant.model.Table;

public class ReservationDao {

	public int doReservation(Connection connection, Reservation reservation) throws SQLException {

		int result = 0;

		String sql = "insert into reservation_tbl (res_date,res_time,res_partySize,res_cust_name,res_phoneNumber,table_id) values(?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, reservation.getReserveDate());
		ps.setString(2, reservation.getReserveTime());
		ps.setInt(3, reservation.getReservePartySize());
		ps.setString(4, reservation.getReserveCustomerName());
		ps.setString(5, reservation.getReservePhoneNumber());
		ps.setInt(6, reservation.getReserveTableId());

//		ps.setString(1, "raju");
//		ps.setString(2, "BBSR");
//		ps.setString(3, "7635134765");
//		ps.setString(4, "raju@gmail.com");
//		ps.setString(5, "1234");

		int records = ps.executeUpdate();
		
		

		System.out.println(records);

	

		return result;
	}
}
