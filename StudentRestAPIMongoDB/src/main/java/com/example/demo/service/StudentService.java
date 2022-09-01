package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.FamilyDetails;
import com.example.demo.model.MarksSheet;
import com.example.demo.model.Student;
import com.example.demo.repository.FamilyDetailsRepository;
import com.example.demo.repository.MarksSheetRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	MarksSheetRepository marksSheetRepository;
	
	@Autowired
	FamilyDetailsRepository familyDetailsRepository;

	public Student createStudent(Student student) {
		
		if (student.getMarksSheet() != null && student.getMarksSheet().size() > 0) {
			marksSheetRepository.saveAll(student.getMarksSheet());
		}
		if (student.getFamilyDetails() != null && student.getFamilyDetails().size() > 0) {
			familyDetailsRepository.saveAll(student.getFamilyDetails());
		}
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudentbyId(String id) {
		return studentRepository.findById(id).get();
	}
	
	public Student updateStudent(String id, Student currentStudent) throws ResourceNotFoundException{
		Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not found for the id : " +id));
		
		if(currentStudent.getName() != null || currentStudent.getName() != "")
			student.setName(currentStudent.getName());
		
		if(currentStudent.getGrade() > 0)
			student.setGrade(currentStudent.getGrade());
		
		if(currentStudent.getDept() != null || currentStudent.getName() != "")
			student.setDept(currentStudent.getDept());
		
		if(currentStudent.getClassroom() != 0)
			student.setClassroom(currentStudent.getClassroom());
		
		studentRepository.save(student);
		
		return student;
	}
	
	public String deleteStudent(String id) throws ResourceNotFoundException{
		studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not found for the id : " +id));
		studentRepository.deleteById(id);
		return "student data deleted successfully";
	}
	
	// Marks sheet API implementation
	public Student addMarksSheet(String id, List<MarksSheet> currentMarksSheet) throws ResourceNotFoundException{
		
		Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not found for the id : " +id));
		
			List<MarksSheet> updatedMarksSheet = new ArrayList<>(currentMarksSheet);
			 
			updatedMarksSheet.addAll(student.getMarksSheet());
			student.setMarksSheet(updatedMarksSheet);
			studentRepository.save(student);
			return student;
	}

	public MarksSheet getMarksSheetById(String id) throws ResourceNotFoundException{
		return marksSheetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarksSheet Not found for the id : " +id));
	}
	
	public List<MarksSheet> getMarksSheetByStudentId(String studentId) throws ResourceNotFoundException{
		Student student = studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student Not found for the id : " +studentId));
		
		return student.getMarksSheet();
	}

	public MarksSheet updateMarksSheetById(String id, MarksSheet marksSheet) throws ResourceNotFoundException {
		
		MarksSheet currentMarksSheet = marksSheetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarksSheet Not found for the id : " +id));
		
		if(marksSheet.getSemester() !=0)
			currentMarksSheet.setSemester(marksSheet.getSemester());
		if(marksSheet.getSub1() >= 0)
			currentMarksSheet.setSub1(marksSheet.getSub1());
		if(marksSheet.getSub2() >= 0)
			currentMarksSheet.setSub2(marksSheet.getSub2());
		if(marksSheet.getSub3() >= 0)
			currentMarksSheet.setSub3(marksSheet.getSub3());
		if(marksSheet.getSub4() >= 0)
			currentMarksSheet.setSub4(marksSheet.getSub4());
		if(marksSheet.getSub5() >= 0)
			currentMarksSheet.setSub5(marksSheet.getSub5());
		if(marksSheet.getSub6() >= 0)
			currentMarksSheet.setSub6(marksSheet.getSub6());
		
		marksSheetRepository.save(currentMarksSheet);
		
		return currentMarksSheet;
	}

	public String deleteMarksSheetById(String id) throws ResourceNotFoundException{
		marksSheetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarksSheet Not found for the id : " +id));
		marksSheetRepository.deleteById(id);
		
		return "markssheet deleted successfully";
	}
	
	// Family Details API implementation

	public Student addFamilyDetails(String id, List<FamilyDetails> currentFamilyDetails) throws ResourceNotFoundException{
		Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not found for the id : " +id));
		
		List<FamilyDetails> updatedfamilyDetails = new ArrayList<>(currentFamilyDetails);
		 
		updatedfamilyDetails.addAll(student.getFamilyDetails());
		student.setFamilyDetails(updatedfamilyDetails);
		studentRepository.save(student);
		return student;
	}

	public FamilyDetails getFamilyDetailsById(String id) throws ResourceNotFoundException{
			return familyDetailsRepository.findById(id).orElseThrow(() -> 
											new ResourceNotFoundException("Family Details Not found for the id : " +id));
		
	}

	public List<FamilyDetails> getFamilyDetailsByStudentId(String studentId) throws ResourceNotFoundException{
		Student student = studentRepository.findById(studentId).orElseThrow(()-> 
											new ResourceNotFoundException("Family Details Not found for the id : " +studentId));
		
		return student.getFamilyDetails();
	}

	public FamilyDetails updateFamilyDetailsById(String id, FamilyDetails familyDetails) throws ResourceNotFoundException{
		FamilyDetails currentFamilyDetails = familyDetailsRepository.findById(id).orElseThrow(() -> 
											new ResourceNotFoundException("Family Details Not found for the id : " +id));
		
		if(familyDetails.getRelation() != null)
			currentFamilyDetails.setRelation(familyDetails.getRelation());
		
		if(familyDetails.getAge()>0)
			currentFamilyDetails.setAge(familyDetails.getAge());
		
		if(familyDetails.getPhoneNumber() > 999999999L && familyDetails.getPhoneNumber()<=9999999999L)
			currentFamilyDetails.setPhoneNumber(familyDetails.getPhoneNumber());
		
		if(familyDetails.getOccupation() != null)
			currentFamilyDetails.setOccupation(familyDetails.getOccupation());
		
		familyDetailsRepository.save(currentFamilyDetails);
				
		return currentFamilyDetails;
	}

	public String deleteFamilyDetails(String id) throws ResourceNotFoundException{
		familyDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family Details Not found for the id : " +id));
		familyDetailsRepository.deleteById(id);
		
		return "Family details deleted successfully";
	}

	
	
	
}
