package com.oupp.restaurant.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oupp.restaurant.dao.ReservationDao;
import com.oupp.restaurant.model.Customer;
import com.oupp.restaurant.model.Reservation;
import com.oupp.restaurant.model.Table;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ReservationDao reservationDao;

	String url = "jdbc:mysql://localhost:3306/RestaurnantReservation?useSSL=false";
	String user = "root";
	String password = "Rajendra@716";

	public ReservationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Table table = new Table();
		
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String fullName = request.getParameter("fullName");
		String phoneNo = request.getParameter("phoneno");
		String partySize = request.getParameter("partySize");

		Reservation reservation = new Reservation();

		reservation.setReserveCustomerName(fullName);
		reservation.setReserveDate(date);
		reservation.setReserveTime(time);
		reservation.setReservePartySize(Integer.parseInt(partySize));
		reservation.setReservePhoneNumber(phoneNo);
		
		HttpSession session = request.getSession();
		//session.getAttribute(table);
		reservation.setReserveTableId(table.getId());

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			int r = reservationDao.doReservation(connection, reservation);
			System.out.println(r);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
