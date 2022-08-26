package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FamilyDetailsDTO;
import com.example.demo.model.FamilyDetails;

public interface FamilyDetailsService {
	
	FamilyDetails saveFamilyDetails(FamilyDetails familyDetails);
	List<FamilyDetails> getAllFamilyDetails();
	List<FamilyDetailsDTO> getFamilyDetailsByStudentId(long studentId);
	FamilyDetails updateFamilyDetails(FamilyDetails familyDetails, long id);
	void deleteFamilyDetails(long id);
	
}
