package com.cdac.app;

import java.time.LocalDate;
import java.util.List;

import com.cdac.dao.EmployeeAddressDao;
import com.cdac.entity.Address;
import com.cdac.entity.Employee;

public class EmployeeAddressTest {

	public static void main(String[] args) {
		EmployeeAddressDao dao = new EmployeeAddressDao();
		
		/* ------------------ scenario 1 ---------------- */
		/* first adding employee, then adding address for that employee */
		//adding an employee
		/*Employee emp = new Employee();
		emp.setName("Anupama");
		emp.setSalary(30000);
		emp.setDateOfJoining(LocalDate.of(2023, 6, 25));
		dao.store(emp);*/
		
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
		
		/* ------------------ scenario 2 ---------------- */
		/* add employee and address together in the database */
		/*Employee emp = new Employee();
		emp.setName("Vipul");
		emp.setSalary(30000);
		emp.setDateOfJoining(LocalDate.of(2023, 5, 25));
		
		Address addr = new Address();
		addr.setCity("Pune");
		addr.setState("Maharashtra");
		addr.setPincode(411001);
		
		emp.setAddress(addr);
		
		dao.store(emp);*/
		//the above code will fail with the following error:
		//Caused by: java.lang.IllegalStateException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.cdac.entity.Employee.address -> com.cdac.entity.Address
		//how to remove this error?
		//we need to use cascade in the association of Employye & Address
		
		/* ------- testing select queries --------- */
		//List<Employee> list = dao.findBySalary(25000);
		//List<Employee> list = dao.findByJoiningYear(2023);
		/*List<Employee> list = dao.findByCity("Nashik");
		for(Employee emp : list) {
			System.out.println(emp.getEmpId());
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
			System.out.println(emp.getDateOfJoining());
			//print the address also
			System.out.println("-------------------");
		}*/
		
		//fetching Employee and checking if Address is also getting fetched or not
		Employee emp = dao.findByPK(2);
		System.out.println(emp.getEmpId());
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
		System.out.println(emp.getDateOfJoining());
		
		Address addr = emp.getAddress();
		System.out.println(addr.getAddrId());
		System.out.println(addr.getCity());
		System.out.println(addr.getState());
		System.out.println(addr.getPincode());
	}
}
