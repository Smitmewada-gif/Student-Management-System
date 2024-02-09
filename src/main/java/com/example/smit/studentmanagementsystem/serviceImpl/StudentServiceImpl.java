package com.example.smit.studentmanagementsystem.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.smit.studentmanagementsystem.entity.Student;
import com.example.smit.studentmanagementsystem.repository.StudentRepository;
import com.example.smit.studentmanagementsystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	
	
	public StudentServiceImpl(StudentRepository sutdentRepository) {
		super();
		this.studentRepository = sutdentRepository;
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
}
