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
 * Servlet implementation class FetchCustomerServlet
 */
public class FetchCustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cid"));
		
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.findByPK(id);
		
		//use jsp to display the data instead (mvc)
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<br/> ID : " + customer.getId());
		out.write("<br/> Name : " + customer.getName());
		out.write("<br/> Email : " + customer.getEmail());
		out.write("<br/> Date of birth : " + customer.getEmail());
		out.write("<br/> City : "+ customer.getCity());
		out.write("</body></html>");
	}

}
