package com.cdac.test;

import java.time.LocalDate;

import org.junit.Test;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Course;
import com.cdac.entity.Enrollment;
import com.cdac.entity.Student;

public class StudentCourseEnrollmentTest {

	@Test
	public void addStudent() {
		Student student = new Student();
		student.setName("Om");
		student.setEmail("om@gmail.com");
		student.setMobileNumber(9988776655L);
		
		GenericDao dao = new GenericDao();
		dao.save(student);
	}
	
	@Test
	public void addCourse() {
		Course course = new Course();
		course.setName("React");
		course.setDuration(2);
		course.setFees(5000);
		
		GenericDao dao = new GenericDao();
		dao.save(course);
	}
	
	@Test
	public void enroll() {
		GenericDao dao = new GenericDao();
		Student student = (Student) dao.findByPK(Student.class, 1);
		Course course = (Course) dao.findByPK(Course.class, 2);
		
		Enrollment enrollment = new Enrollment();
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		enrollment.setDate(LocalDate.now());
		dao.save(enrollment);
	}
}
