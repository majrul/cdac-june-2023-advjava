package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

/*
 * TODO: CREATE THIS TABLE IN THE DATABASE BEFORE RUNNING THIS CODE:
CREATE TABLE TBL_CARPART
(PART_NO INT AUTO_INCREMENT PRIMARY KEY,
 PART_NAME VARCHAR(25),
 CAR_MODEL VARCHAR(25),
 PRICE DOUBLE,
 QUANTITY INT);
 
 In the first version, we used Spring to create object of this class and nothing else
 */
@Component("carPartsInv1")
public class CarPartsInventoryImpl1 implements CarPartsInventory {

	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//long ms1 = System.currentTimeMillis();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			//long ms2 = System.currentTimeMillis();
			//System.out.println("Approx time to connect : "  + (ms2 - ms1) +  " ms");
			String sql = "insert into tbl_carpart(part_name, car_model, price, quantity) values(?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, carPart.getPartName());
			st.setString(2, carPart.getCarModel());
			st.setDouble(3, carPart.getPrice());
			st.setInt(4,  carPart.getQuantity());
			st.executeUpdate();
		}
		catch(ClassNotFoundException | SQLException e) {
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
