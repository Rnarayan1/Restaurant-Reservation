package com.oupp.restaurant.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oupp.restaurant.dao.CustomerDao;
import com.oupp.restaurant.util.JdbcConnectivity;
import com.oupp.restaurant.util.Registration;

@WebServlet("/registerCustomerServlet")
public class CustomerRegisterServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	private CustomerDao customerDao = new CustomerDao();

	public CustomerRegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 System.out.println("registerCustomerServlet start");
		
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phoneNo = request.getParameter("phoneno");

		Registration registration = new Registration();
		registration.setName(fullName);
		registration.setAddress(address);
		registration.setPhNo(phoneNo);
		registration.setEmail(email);
		registration.setPassword(password);

		int res = 0;

		try {

			System.out.println(registration);
			res = customerDao.registerCustomer(registration);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Redirect or respond to the client accordingly
		if (res > 0) {
			response.sendRedirect("SuccessfullyRegistered/SuccessfullyRegistered.jsp");
		}
		
		System.out.println("registerCustomerServlet end");
	}

}
