package com.oupp.restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oupp.restaurant.dao.TableDao;
import com.oupp.restaurant.model.Table;

@WebServlet("/TablesController")
public class TablesController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	TableDao tableDao = new TableDao();
	
	public TablesController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("hiiii");
		int r = 0;
		// Process the form data submitted to this servlet
		// Retrieve parameters from the request object
		int totalTables = Integer.parseInt(request.getParameter("totalTables"));
		int twoSeater = Integer.parseInt(request.getParameter("twoSeater"));
		int fourSeater = Integer.parseInt(request.getParameter("fourSeater"));
		int sixSeater = Integer.parseInt(request.getParameter("sixSeater"));
		int twelveSeater = Integer.parseInt(request.getParameter("twelveSeater"));

		Table table = new Table();
		
		ArrayList<Integer> tab = new ArrayList<>();
		
		tab.add(twoSeater);
		tab.add(fourSeater);
		tab.add(sixSeater);
		tab.add(twelveSeater);
		
		// Perform operations with the received data (e.g., save to database)
		Iterator it = tab.iterator();
		while(it.hasNext()){
			int n = (int) it.next();
			int num = n;
			System.out.println(n);
			while(n!=0){
				table.setCapacity(num);
				table.setAvailable(true);
				try {
					r = tableDao.addTable(table);
				} catch (Exception e) {
					e.printStackTrace();
				}
				n--;
			}
		}
		
		
		// Redirect or send response
		// For instance:
		if(r > 0) response.sendRedirect("registrationSuccess.html");
	}

}
