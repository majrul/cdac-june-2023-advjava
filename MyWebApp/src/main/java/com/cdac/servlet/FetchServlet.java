package com.cdac.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchServlet
 * 
 * In this example, we will fetch the customer data from the db and display it to the user
 * For reading the result of a select query, we need to additionally create ResultSet object in our code
 */
@WebServlet("/fetch.cdac")
public class FetchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("custid"));
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd"); //url, username & password
			String sql = "select name,email from customer where id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery(); //output of the select query will be stored in resultset object
			if(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				System.out.println(name);
				System.out.println(email);
				//TODO: Instead of displaying on the console, display it using HTML
			}
			else {
				System.out.println("no record found!");
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

		
	}

}
