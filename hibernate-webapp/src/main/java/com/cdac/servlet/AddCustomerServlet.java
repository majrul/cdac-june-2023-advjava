package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

/**
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String city = request.getParameter("city");
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		//customer.setDateOfBirth(dob); --todo: set this correctly
		customer.setCity(city);
		
		CustomerDao dao = new CustomerDao();
		dao.store(customer);
		
		response.sendRedirect("confirmation.jsp");
		//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		/*PrintWriter out = response.getWriter();
		out.write("<h1>Customer added successfully!</h1>");*/
	}

}
