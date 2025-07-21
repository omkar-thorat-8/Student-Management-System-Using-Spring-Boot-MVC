package com.sms.Student_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sms.Student_Management_System.model.Student;
import com.sms.Student_Management_System.repository.StudentReposoitory;
import com.sms.Student_Management_System.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String ListStudents(Model model) {
		
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/student/new")
	public String createStudent(Model model) {
		
		// create student objecr to hold the student from data
		Student student = new Student();
		
		model.addAttribute("students",student);
		
		return "AddStudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("students") Student student) {
	
		studentService.saveStudent(student);
		return "redirect:/students"; 
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
		
		model.addAttribute("student",studentService.getStudentById(id));
		
		return "updateStudent";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(
			@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model
			) {
		
		//get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//save updated student object
		
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	
	//handler to handle delete student req
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		
		studentService.deleteStudentById(id);
		
		return "redirect:/students";
		
	}
}
