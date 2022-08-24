package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}	

	// Create Student REST API
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		
		return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	// Get all students REST API
	@GetMapping()
	public List<Student> getAllStudents(){
		
		return studentService.getAllStudents();
	}
	
	// Get student by Id REST API
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId){
		return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
	}
	
	// updated student by Id REST API
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long studentId){
		
		return new ResponseEntity<Student>(studentService.updateStudent(student, studentId), HttpStatus.OK);
	}

}
