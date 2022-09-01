package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.FamilyDetails;
import com.example.demo.model.MarksSheet;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/allstudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentbyId(@PathVariable String id) {
		return studentService.getStudentbyId(id);
	}
	
	@PutMapping("/update/student/{id}")
	public Student updateStudent(@PathVariable(value = "id") String id,
								@RequestBody Student currentStudent) throws ResourceNotFoundException {
		return studentService.updateStudent(id, currentStudent);
	}
	
	@DeleteMapping("/delete/student/{id}")
	public String deleteStudent(@PathVariable(value = "id") String id) throws ResourceNotFoundException{
		return studentService.deleteStudent(id);
	}
	
//	@PostMapping("/marks sheet/{id}")
//	public MarksSheet createMarksSheet(@PathVariable(value = "id") String id, 
//			@RequestBody List<MarksSheet> marksSheet ) {
//		
//	}
	
	@PostMapping("/markssheet/student/{id}")
	public Student addMarksSheet(@PathVariable(value = "id") String id, 
									@RequestBody List<MarksSheet> marksSheet ) throws ResourceNotFoundException{
		return studentService.addMarksSheet(id, marksSheet);
	}
	
	@GetMapping("/markssheet/{id}")
	public MarksSheet getMarksSheetById(@PathVariable(value = "id") String id) throws ResourceNotFoundException{
		return studentService.getMarksSheetById(id);
	}
	
	@GetMapping("/markssheet/student/{id}")
	public List<MarksSheet> getMarksSheetByStudentId(@PathVariable(value = "id") String studentId) throws ResourceNotFoundException{
		return studentService.getMarksSheetByStudentId(studentId);
	}
	
	@PutMapping("/markssheet/{id}")
	public MarksSheet updateMarksSheetById(@PathVariable(value = "id") String id,
											@RequestBody MarksSheet marksSheet) throws ResourceNotFoundException{
		
		return studentService.updateMarksSheetById(id, marksSheet);
	}
	
	@DeleteMapping("/markssheet/{id}")
	public String deleteMarksSheetById(@PathVariable(value = "id") String id) throws ResourceNotFoundException{
		
		return studentService.deleteMarksSheetById(id);
	}
	
	@PostMapping("/familydetails/student/{id}")
	public Student addFamilyDetails(@PathVariable(value = "id") String id, 
			@RequestBody List<FamilyDetails> familyDetails ) throws ResourceNotFoundException{
		return studentService.addFamilyDetails(id, familyDetails);
	}
	
	@GetMapping("/familydetails/{id}")
	public FamilyDetails getFamilyDetailsById(@PathVariable(value = "id") String id) throws ResourceNotFoundException{
		return studentService.getFamilyDetailsById(id);
	}
	
	@GetMapping("/familydetails/student/{id}")
	public List<FamilyDetails> getFamilyDetailsByStudentId(@PathVariable(value = "id") String studentId) throws ResourceNotFoundException{
		return studentService.getFamilyDetailsByStudentId(studentId);
	}
	
	@PutMapping("/familydetails/{id}")
	public FamilyDetails updateFamilyDetailstById(@PathVariable(value = "id") String id,
											@RequestBody FamilyDetails familyDetails) throws ResourceNotFoundException{
		
		return studentService.updateFamilyDetailsById(id, familyDetails);
	}
	
	@DeleteMapping("/familydetails/{id}")
	public String deleteFamilyDetailsById(@PathVariable(value = "id") String id) throws ResourceNotFoundException{
		
		return studentService.deleteFamilyDetails(id);
	}
}
