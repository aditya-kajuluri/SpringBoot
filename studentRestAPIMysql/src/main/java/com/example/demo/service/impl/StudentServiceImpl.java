package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;


	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}


	@Override
	public Student getStudentById(long id) {
		
		// Lambda expression
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
	}


	@Override
	public Student updateStudent(Student student, long id) {
		
		// check id exists in DB
		Student currentStudent = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "Id", id));
		
		if(student.getName() != null || student.getName() != "")
		currentStudent.setName(student.getName());
		
		if(student.getGrade() != 0)
		currentStudent.setGrade(student.getGrade());
		
		if(student.getDept() != null || student.getName() != "")
		currentStudent.setDept(student.getDept());
		
		if(student.getClassRoom() != 0)
		currentStudent.setClassRoom(student.getClassRoom());
		
		studentRepository.save(currentStudent);
		
		return currentStudent;
	}

}
