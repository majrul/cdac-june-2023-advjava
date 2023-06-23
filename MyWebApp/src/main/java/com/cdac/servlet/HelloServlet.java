package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/hello.cdac") //mapping / url-pattern
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Welcome to Java based web application development!</h1>");
		String str = "Hello Everyone!";
		out.write("<h1>" + str + "</h1>");
		LocalTime time = LocalTime.now();
		if(time.getHour() >= 4 && time.getHour() < 12)
			out.write("<h2>Good Morning!</h2>");
		else if(time.getHour() >= 12 && time.getHour() < 16)
			out.write("<h2>Good Afternoon!</h2>");
		else if(time.getHour() >= 16 && time.getHour() < 21)
			out.write("<h2>Good Evening!</h2>");
		else
			out.write("<h2>Good Night!</h2>");
		
		out.write("</body></html>");
	}

}
