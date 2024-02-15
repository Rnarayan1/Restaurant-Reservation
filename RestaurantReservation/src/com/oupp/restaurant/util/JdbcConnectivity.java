package com.oupp.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class JdbcConnectivity {

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static Connection getDbConnection() throws SQLException {
		// Establish the connection
		String url = "jdbc:mysql://localhost:3306/RestaurnantReservation?useSSL=false";
		String user = "root";
		String password = "root";
		return DriverManager.getConnection(url, user, password);
	}

	public static void closeResources(ResultSet resultSet, Statement statement, Connection connection)
			throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
