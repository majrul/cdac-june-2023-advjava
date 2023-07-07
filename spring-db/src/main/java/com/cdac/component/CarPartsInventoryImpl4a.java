package com.cdac.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 * In  this  version, we will use Spring's JdbcTemplate class.
 * This is a good option in case if we don't want to use Hibernate/JPA
 * 
 * Why are we creating JdbcTemplate object?
 * - Instead, can we not inject the JdbcTemplate object in our code?
 * - TODO: Modify this code to inject the JdbcTemplate object
 */
@Component("carPartsInv4a")
public class CarPartsInventoryImpl4a implements CarPartsInventory {

	@Autowired
	private DataSource dataSource;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);

		String sql = "insert into tbl_carpart(part_name, car_model, price, quantity) values(?, ?, ?, ?)";
		jt.update(sql, carPart.getPartName(), carPart.getCarModel(), carPart.getPrice(), carPart.getQuantity());
	}
	
	public List<CarPart> getAvailableParts() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		
		List<CarPart> list = jt.query("select * from tbl_carpart", BeanPropertyRowMapper.newInstance(CarPart.class));
		return list;
	}

}








