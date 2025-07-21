package com.sms.Student_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.Student_Management_System.model.Student;

public interface StudentReposoitory extends JpaRepository<Student, Long> {

	
}
