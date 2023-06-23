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
@WebServlet("/fetch-all.cdac")
public class FetchAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd"); //url, username & password
			String sql = "select id,name,email from customer";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery(); //output of the select query will be stored in resultset object
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println("-------");
				//TODO: Instead of displaying on the console, display it using HTML
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
