package com.oupp.restaurant.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oupp.restaurant.dao.RestaurnantDao;
import com.oupp.restaurant.util.Registration;

@WebServlet("/registerRestaurantServlet")
public class RestaurantRegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RestaurnantDao restaurnantDao = new RestaurnantDao();


	public RestaurantRegisterController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int res = 0;
		String restaurantName = request.getParameter("restaurantName");
		String capacity = request.getParameter("capacity");
		String numberOfTables = request.getParameter("numberOfTables");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phoneNo = request.getParameter("phoneno"); 

		Registration registration = new Registration();

		registration.setName(restaurantName);
		registration.setCapacity(Integer.parseInt(capacity));
		registration.setNumberOfTables(Integer.parseInt(numberOfTables));
		registration.setEmail(email);
		registration.setPassword(password);
		registration.setAddress(address);
		registration.setPhNo(phoneNo);

		try {
			 
			System.out.println("Hello.......................");
			res = restaurnantDao.addRestaurnant(registration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(res);
		
		// Redirect or respond to the client accordingly
		//if(res > 0) response.sendRedirect("RestaurantTableDetails.jsp");
	}

}
