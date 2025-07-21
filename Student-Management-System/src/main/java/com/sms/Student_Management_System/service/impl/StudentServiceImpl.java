package com.sms.Student_Management_System.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.Student_Management_System.model.Student;
import com.sms.Student_Management_System.repository.StudentReposoitory;
import com.sms.Student_Management_System.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentReposoitory studentReposoitory;
	
	@Override
	public List<Student> getAllStudents() {
		
		return studentReposoitory.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentReposoitory.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentReposoitory.findById(id).get();
	}
	
	@Override
	public Student updateStudent(Student student) {
		return studentReposoitory.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {

		studentReposoitory.deleteById(id);
	}

}
