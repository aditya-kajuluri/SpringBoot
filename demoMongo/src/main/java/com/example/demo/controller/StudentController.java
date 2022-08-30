package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) throws ResourceNotFoundException{
		
		Student student = studentRepository.findById(studentId)
							.orElseThrow(() -> new ResourceNotFoundException("Student Not found for the id : " +studentId));
		
		return ResponseEntity.ok().body(student);
		
	}
	
	@PostMapping
	public Student createStudent(@Valid @RequestBody Student student) {
		student.setId(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
		return studentRepository.save(student);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId, 
												@Valid @RequestBody Student studentDetails) throws ResourceNotFoundException{
		Student student = studentRepository.findById(studentId)
							.orElseThrow(()-> new ResourceNotFoundException("Student Not found for the id : " +studentId));
		if(studentDetails.getFirstName()!= null || studentDetails.getFirstName() == "")
		student.setFirstName(studentDetails.getFirstName());
		
		if(studentDetails.getLastName()!= null || studentDetails.getLastName() == "")
		student.setLastName(studentDetails.getLastName());
		
		if(studentDetails.getEmailId()!= null || studentDetails.getEmailId() == "")
		student.setEmailId(studentDetails.getEmailId());
		
		final Student updatedStudent = studentRepository.save(student);
		
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId) throws ResourceNotFoundException{
		Student student = studentRepository.findById(studentId)
				.orElseThrow(()-> new ResourceNotFoundException("Student Not found for the id : " +studentId));
		
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
}
