package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 * 
 * This code uses JDBC and Statement API for inserting customer data in the Database
 * When using Statement API, we have to worry about concatenating data in the sql query correct, which can be error prone
 * Before we run this code:
 * 1. We had to create table in the Database:
 * 	  create table customer(id int auto_increment primary key, name varchar(25), email varchar(50), password varchar(12));
 * 2. We had to download the mysql jdbc driver from the net:
 * 		https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j-8.0.33.zip
 * 		After extracting it, we copied the mysql-connector...jar file into our project's WEB-INF/lib directory
 */
@WebServlet("/register.cdac")
public class RegisterServlet extends HttpServlet {

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
			Statement st = conn.createStatement(); //Statement object used for firing SQL statements
			//String sql = "insert into customer(name, email, password) values('Majrul', 'majrul@gmail.com', 'passw0rd')";
			String sql = "insert into customer(name, email, password) values('"+name+"', '"+email+"', '"+password+"')";
			System.out.println(sql);
			st.executeUpdate(sql); //DML
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
