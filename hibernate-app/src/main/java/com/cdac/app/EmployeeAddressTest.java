package com.cdac.app;

import java.time.LocalDate;

import com.cdac.dao.EmployeeAddressDao;
import com.cdac.entity.Address;
import com.cdac.entity.Employee;

public class EmployeeAddressTest {

	public static void main(String[] args) {
		EmployeeAddressDao dao = new EmployeeAddressDao();
		
		//adding an employee
		Employee emp = new Employee();
		emp.setName("Anupama");
		emp.setSalary(30000);
		emp.setDateOfJoining(LocalDate.of(2023, 6, 25));
		dao.store(emp);
		
		//adding address for an existing employee
		/*Employee emp = dao.findByPK(2);
		//Employee emp = dao.findByName("Anupama");
		Address addr = new Address();
		addr.setCity("Pune");
		addr.setState("Maharashtra");
		addr.setPincode(411001);
		dao.store(addr);
		emp.setAddress(addr);
		dao.update(emp);*/
		
	}
}
