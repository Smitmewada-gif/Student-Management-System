package com.example.smit.studentmanagementsystem.service;

import java.util.List;

import com.example.smit.studentmanagementsystem.entity.Student;

public interface StudentService {
	List<Student> getAll();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);

	void deleteStudent(Long id);
}
