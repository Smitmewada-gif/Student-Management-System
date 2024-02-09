package com.example.smit.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smit.studentmanagementsystem.entity.Student;
import com.example.smit.studentmanagementsystem.repository.StudentRepository;
import com.example.smit.studentmanagementsystem.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;

//	public StudentController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}
	
	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students", studentService.getAll());
		return "students";
	}
	
	@GetMapping("/student/new")
	public String createStudentFrom(Model model) {
		Student student = new Student();
		model.addAttribute("student", student); 
		return "create_student";
	}
	 
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
//		studentRepository.save(student); // we can use this also
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("form-data") Student student) {
		
		// get student from database by id and update
		Student existingStudent = studentService.getStudentById(id);
		
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// now save this into database
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
//		studentRepository.deleteById(id);
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
}
