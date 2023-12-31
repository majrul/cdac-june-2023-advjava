package com.cdac.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.model.Customer;
import com.cdac.model.CustomerDataLoader;

/**
 * Servlet implementation class CustomerPaginationServlet
 */
@WebServlet("/CustomerPaginationServlet")
public class CustomerPaginationServlet extends HttpServlet {

	int cursor = 0;
	int pageSize = 5;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		if(page != null) {
			if(page.equals("next"))
				cursor += pageSize;
			else if(page.equals("prev"))
				cursor -= pageSize;
		}
		else
			cursor = 0;
		
		CustomerDataLoader custDataLoader = new CustomerDataLoader();
		List<Customer> listOfCustomers = custDataLoader.loadCustomerData();
		
		List<Customer> current5Customers =  listOfCustomers.subList(cursor, cursor + pageSize);

		HttpSession session = request.getSession();
		session.setAttribute("5c", current5Customers);
		
		response.sendRedirect("viewCustomerData.jsp");
	}

}
