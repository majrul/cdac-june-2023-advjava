package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info.cdac")
public class InfoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nm");
		String email = request.getParameter("em");
		
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1 style='color:red'>Hello " + name.toUpperCase() + "</h1>");
		out.write("<h2>Your email address is " + email + "</h2>");
		out.write("</body></html>");
	}

}
