package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		//code to check if the username/password is valid in the DB missing
		//as of now i will hardcode the condition
		if(username.equals("majrul") && password.equals("123")) {
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("uname", username);
				Cookie c2 = new Cookie("pwd", password);
				c1.setMaxAge(60*60); //seconds
				c2.setMaxAge(60*60);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("loginUsingCookies.jsp");
		}
	}

}
