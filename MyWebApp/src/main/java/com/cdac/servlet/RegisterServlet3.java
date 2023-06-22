package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 * 
 * In this example, we tried fetching the generated pk, i.e the customer id from the database dynamically
 */
@WebServlet("/register3.cdac")
public class RegisterServlet3 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading data sent by the client
		String name = request.getParameter("nm");
		String email = request.getParameter("em");
		String password = request.getParameter("pw");
		
		//jdbc code to store the data in the db
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //loading the jdbc driver (type 4)
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd"); //url, username & password
			String sql = "insert into customer(name, email, password) values(?, ?, to_base64(?))";
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //pre compiled sql
			//substituting ? with the actual value
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, password);
			//st.setString(3, Base64.getEncoder().encodeToString(password.getBytes()));
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if(rs != null && rs.next()) {
				System.out.println("Generated id " + rs.getInt(1));
				//TODO: Display the ID in the HTML generated below
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
		
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Thank you for registering with us!</h1>");
		out.write("</body></html>");
	}

}
