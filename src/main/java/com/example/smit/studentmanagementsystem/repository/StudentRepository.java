package com.example.smit.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smit.studentmanagementsystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
