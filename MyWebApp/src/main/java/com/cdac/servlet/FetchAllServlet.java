package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd"); //url, username & password
			String sql = "select id,name,email from customer";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery(); //output of the select query will be stored in resultset object
			
			out.write("<html>");
			out.write("<head>");
			out.write("<link rel='stylesheet' href='styles.css'>");
			out.write("</head>");
			out.write("<body>");
			out.write("<table border='1'>");
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println("-------");
				//TODO: Instead of displaying on the console, display it using HTML
				out.write("<tr>");
				out.write("<td>" + id + "</td>");
				out.write("<td>" + name + "</td>");
				out.write("<td>" + email + "</td>");
				out.write("</tr>");
			}
			out.write("</table></body></html>");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

		
	}

}
