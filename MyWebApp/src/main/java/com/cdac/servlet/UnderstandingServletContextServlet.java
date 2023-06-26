package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnderstandingServletContextServlet
 */
@WebServlet("/UnderstandingServletContextServlet")
//TODO: Check what is ServletConfig and how is it different from ServletContext
public class UnderstandingServletContextServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sCtx = getServletContext();
		
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>" + sCtx.getServerInfo() + "</h1>");
		
		int startTime = Integer.parseInt(sCtx.getInitParameter("startTime"));
		int endTime = Integer.parseInt(sCtx.getInitParameter("endTime"));
		
		LocalTime time = LocalTime.now();
		if(time.getHour() >= startTime && time.getHour() <= endTime)
			out.write("<h2>You are on time, please continue..</h2>");
		else
			out.write("<h2>Sorry, you need to come back tomorrow</h2>");
		
		out.write("</body></html>");
	}

}
