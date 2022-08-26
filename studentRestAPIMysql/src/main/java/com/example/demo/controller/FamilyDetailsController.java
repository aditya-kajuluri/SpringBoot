package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FamilyDetailsDTO;
import com.example.demo.model.FamilyDetails;
import com.example.demo.service.FamilyDetailsService;

@RestController
@RequestMapping("/familydetails")
public class FamilyDetailsController {
	
	

	private FamilyDetailsService familyDetailsService;

	public FamilyDetailsController(FamilyDetailsService familyDetailsService) {
		super();
		this.familyDetailsService = familyDetailsService;
	}
	
	
	// Create API
	@PostMapping()
	public ResponseEntity<FamilyDetails> saveFamilyDetails(@RequestBody FamilyDetails familyDetails){
		
		return new ResponseEntity<>(familyDetailsService.saveFamilyDetails(familyDetails), HttpStatus.CREATED);
		
	}
	
	// Get all details API
	@GetMapping()
	public List<FamilyDetails> getAllFamilyDetails(){
		
		return familyDetailsService.getAllFamilyDetails();
		
	}
	
	// Get details with student id API
	@GetMapping("/student/{studentId}")
	public ResponseEntity<List<FamilyDetailsDTO>> getFamilyDetailsByStudentId(@PathVariable("studentId") long studentId) {
		
		return new ResponseEntity<>(familyDetailsService.getFamilyDetailsByStudentId(studentId), HttpStatus.OK);
		
	}
	
	// update family details API
	@PutMapping("{id}")
	public ResponseEntity<FamilyDetails> updateFamilyDetails(@RequestBody FamilyDetails familyDetails, @PathVariable("id") long id) {
		
		return new ResponseEntity<FamilyDetails>(familyDetailsService.updateFamilyDetails(familyDetails, id), HttpStatus.OK);
		
	}
	
	// Delete family details API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteFamilyDetails(@PathVariable("id") long id) {
		
		familyDetailsService.deleteFamilyDetails(id);
		return new ResponseEntity<String>("Family Details deleted successfully", HttpStatus.OK);
		
	}
}
