package com.cdac.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataLoader {

	public List<Customer> loadCustomerData() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd"); //url, username & password
			String sql = "select * from customer";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			List<Customer> list = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				Customer customer = new Customer();
				customer.setId(id);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPassword(password);
				list.add(customer);
			}
			return list;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return new ArrayList<>(); //instead we should throw an exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}
}
