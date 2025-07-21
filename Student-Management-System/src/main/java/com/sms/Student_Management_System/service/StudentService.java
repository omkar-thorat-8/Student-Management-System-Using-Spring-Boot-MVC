package com.sms.Student_Management_System.service;

import java.util.List;

import com.sms.Student_Management_System.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
