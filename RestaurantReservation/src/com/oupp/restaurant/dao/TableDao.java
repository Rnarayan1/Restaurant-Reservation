package com.oupp.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oupp.restaurant.model.Table;
import com.oupp.restaurant.util.JdbcConnectivity;

public class TableDao {


	public int addTable(Table table) throws Exception {

		
		System.out.println("Entered");
		String sql = "insert into tabledetails_tbl (table_id,table_capacity,table_available) values(?,?,?)";
		Connection connection = JdbcConnectivity.getDbConnection();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setInt(1, 101);
		ps.setInt(2, 10);
		ps.setBoolean(3, false);

		int records = ps.executeUpdate();
		System.out.println("Records inserted " + records);
		return 1;
	}

	public void viewTable(Table table) throws Exception {
		String sql = "select * from tabledetails_tbl";
		Connection connection = JdbcConnectivity.getDbConnection();
		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getBoolean(3));
		}
	}

	public int deleteTable(Table table) throws Exception {
		String sql = "delete from tabledetails_tbl where table_id =?";
		Connection connection = JdbcConnectivity.getDbConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 101);

		int records = ps.executeUpdate();
		System.out.println("Records deleted succefully " + records);
		return records;
	}
}
