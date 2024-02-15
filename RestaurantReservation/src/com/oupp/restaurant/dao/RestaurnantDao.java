package com.oupp.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oupp.restaurant.model.Restaurnant;
import com.oupp.restaurant.util.JdbcConnectivity;
import com.oupp.restaurant.util.Login;
import com.oupp.restaurant.util.Registration;

public class RestaurnantDao {

	public int addRestaurnant(Registration registration ) {
		
		System.out.println("Entered");
		int records=0;
		try {
			Connection connection = JdbcConnectivity.getDbConnection();
			PreparedStatement ps = connection.prepareStatement("insert into restaurant_tbl"
					+ "(rest_name,rest_address,rest_phNo,rest_capacity,rest_password,email_id,number_of_tables) values (?,?,?,?,?,?,?);");

			ps.setString(1, registration.getName());
			ps.setString(2, registration.getAddress());
			ps.setString(3,registration.getPhNo());
			ps.setString(4,registration.getEmail());
			ps.setString(5, registration.getPassword());
			ps.setInt(6,registration.getCapacity());
			ps.setInt(7, registration.getNumberOfTables());
			
			
			records = ps.executeUpdate();
			System.out.println("Records updated: " + records);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return records;

	}

	public Restaurnant restaurnantLogin(Login login, Restaurnant restaurnant,Connection connection) {
		try {

			Connection con = JdbcConnectivity.getDbConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from restaurant_tbl where email_id= ? and rest_password=?  ");
			ps.setString(1,login.getUserId());
			ps.setString(2,login.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				restaurnant.setName(rs.getString(2));
				restaurnant.setAddress(rs.getString(3));
				restaurnant.setPhoneNumber(rs.getString(4));
				restaurnant.setCapacity(rs.getInt(5));
				restaurnant.setEmail_id(rs.getString(6));
				restaurnant.setPassword(rs.getString(7));
				restaurnant.setNumberOfTables(rs.getInt(8));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurnant;

	}
	public void restaurantView(Restaurnant restaurnant,Connection connection){
		try{
			
			Connection con = JdbcConnectivity.getDbConnection();
			PreparedStatement ps = con.prepareStatement("select * from restaurant_tbl");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
	            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
	            		" "+rs.getString(4)+" "+rs.getInt(5)+" "
	            		+rs.getString(6)+" "+rs.getString(7)+" "+rs.getInt(8));
	            
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void restaurantUpdate(Restaurnant restaurnant,Connection connection){
		try
		{
			Connection con = JdbcConnectivity.getDbConnection();
			PreparedStatement ps = con.prepareStatement("update restaurant_tbl SET rest_name = ?," + "rest_address = ?,rest_phNo = ?,"
					+ "rest_capacity = ?,email_id = ?,number_of_tables = ? where rest_password =?");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+
			rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void restaurantDelete(Restaurnant restaurnant,Connection connection){
		int records=0;
		try
		{
			
			Connection con = JdbcConnectivity.getDbConnection();
			PreparedStatement ps = con.prepareStatement("delete from restaurant_tbl where rest_password =?");
			System.out.println(restaurnant.getPassword());
			ps.setString(1, restaurnant.getPassword());
			records = ps.executeUpdate();
			System.out.println("Records deleted successfully" + records);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		//return records;
	}
}
