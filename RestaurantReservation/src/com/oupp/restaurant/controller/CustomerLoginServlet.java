package com.oupp.restaurant.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oupp.restaurant.dao.CustomerDao;
import com.oupp.restaurant.model.Customer;
import com.oupp.restaurant.util.Login;

@WebServlet("customerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CustomerDao customerDao = new CustomerDao();



	public CustomerLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Customer login start !!!!!!!!!!!");
		String username = request.getParameter("email");
		String password = request.getParameter("password");

		Login login = new Login();

		login.setUsuerId(username);
		login.setPassword(password);

		try {

			Customer customer = new Customer();
			HttpSession session = request.getSession();

			customer = customerDao.customerLogin(login,customer);
			session.setAttribute("customer", customer);
			if(customer.getName() != null){
				response.sendRedirect("CustomerHomePage/CustomerHomePage.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Inside CustomerLoginServlet doPost method");

		
		System.out.println("Customer login end !!!!!!!!!!!");
	}

}
