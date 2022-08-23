package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student(1, "FirstStudent");
	}
	
	@GetMapping("/allstudents")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "FirstStudent"));
		students.add(new Student(2, "second"));
		students.add(new Student(3, "third"));
		students.add(new Student(4, "fourth"));
		students.add(new Student(5, "fifth"));
		
		return students;
	}
	
	@GetMapping("/student/{studentName}")
	public Student studentPV(@PathVariable("studentName") String firstName) {
		return new Student(1, firstName);
	}
	
	// rest api to handle query parameters
	
	@GetMapping("/student/query")
	public Student studentQueryParam(@RequestParam(name = "firstName") String name) {
		return new Student(1, name);
	}
}
