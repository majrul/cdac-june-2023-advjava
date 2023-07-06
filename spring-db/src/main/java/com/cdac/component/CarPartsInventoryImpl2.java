package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *  In the second version, we used Spring to help us setup a Connection pool in our app and inject the same in the code
 */
@Component("carPartsInv2")
public class CarPartsInventoryImpl2 implements CarPartsInventory {

	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into tbl_carpart(part_name, car_model, price, quantity) values(?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, carPart.getPartName());
			st.setString(2, carPart.getCarModel());
			st.setDouble(3, carPart.getPrice());
			st.setInt(4,  carPart.getQuantity());
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
	
	//TODO: Complete the code for this and test the same
	public List<CarPart> getAvailableParts() {
		return null;
	}

	
}
