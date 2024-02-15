package com.oupp.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.oupp.restaurant.model.Customer;
import com.oupp.restaurant.util.JdbcConnectivity;
import com.oupp.restaurant.util.Login;
import com.oupp.restaurant.util.Registration;

public class CustomerDao {

	public int registerCustomer(Registration registration) throws Exception {

		System.out.println(registration);
		Connection connection = JdbcConnectivity.getDbConnection();
		String sql = "insert into customer_tbl (cust_name,cust_address,cust_phNo,cust_email,cust_password) values(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);

		
		
		ps.setString(1, registration.getName());
		ps.setString(2, registration.getAddress());
		ps.setString(3, registration.getPhNo());
		ps.setString(4, registration.getEmail());
		ps.setString(5, registration.getPassword());

		int records = ps.executeUpdate();

		System.out.println(records);

		return records;
	}

	public Customer customerLogin(Login login,Customer customer) throws Exception {

		//CustomerDao c = new CustomerDao();
		Connection connection = JdbcConnectivity.getDbConnection();
		String sql = "select * from customer_tbl where cust_email = ? and cust_password = ?";
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, login.getUserId());
		ps.setString(2, login.getPassword());

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			customer.setName(rs.getString(2));
			customer.setAddress(rs.getString(3));
			customer.setPhNo(rs.getString(4));
			customer.setEmail(rs.getString(5));
			customer.setPassword(rs.getString(6));

		}
		
		// int res1 = c.customerEdit(connection, customer);
		return customer;
	}

	public int customerEdit(Connection connection, Customer customer) throws Exception {// update
		String sql = "update customer_tbl SET cust_name = ?," + "cust_address = ?,cust_phNo = ?,"
				+ "cust_email = ? where cust_password =?";
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, customer.getName());
		ps.setString(2, customer.getAddress());
		ps.setString(3, customer.getPhNo());
		ps.setString(4, customer.getEmail());
		ps.setString(5, customer.getPassword());

		int records = ps.executeUpdate();
		System.out.println("Record updated succesflly " + records);
		return records;
	}

	public int customerDelete(Connection connection, Customer customer) throws SQLException {

		String sql = "delete from  customer_tbl where cust_password =?";
		PreparedStatement ps = connection.prepareStatement(sql);
		System.out.println(customer.getPassword());
		ps.setString(1, customer.getPassword());

		int records = ps.executeUpdate();
		System.out.println("Records deleted succefully " + records);
		return records;

	}
}
