package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FamilyDetailsDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.FamilyDetails;
import com.example.demo.repository.FamilyDetailsRepository;
import com.example.demo.service.FamilyDetailsService;

@Service("FamilyDetailsService")
public class FamilyDetaisServiceImpl implements FamilyDetailsService{
	
	@Autowired
	private FamilyDetailsRepository familyDetailsRepository;
	
	
	
	public FamilyDetaisServiceImpl(FamilyDetailsRepository familyDetailsRepository) {
		super();
		this.familyDetailsRepository = familyDetailsRepository;
	}

	@Override
	public FamilyDetails saveFamilyDetails(FamilyDetails familyDetails) {
		
		return familyDetailsRepository.save(familyDetails);
	}

	@Override
	public List<FamilyDetails> getAllFamilyDetails() {
		
		return familyDetailsRepository.findAll();
	}

	@Override
	public List<FamilyDetailsDTO> getFamilyDetailsByStudentId(long studentId) {
		
		List<FamilyDetails> currentFamilyDetails = familyDetailsRepository.getFamilyDetailsByStudentId(studentId);
		List<FamilyDetailsDTO> familyDetailsDTO = new ArrayList<>();
		currentFamilyDetails.stream().forEach(a -> {
			familyDetailsDTO.add(entitytoDTO(a));
		});
		
		return familyDetailsDTO;
	}
	
	private FamilyDetailsDTO entitytoDTO(FamilyDetails currentFamilyDetails) {
		
		FamilyDetailsDTO dto = new FamilyDetailsDTO(currentFamilyDetails.getId(), 
								currentFamilyDetails.getRelation(), 
								currentFamilyDetails.getAge(), 
								currentFamilyDetails.getPhoneNo(), 
								currentFamilyDetails.getOccupation(),
								currentFamilyDetails.getFamilyOfStudent().getId(),
								currentFamilyDetails.getFamilyOfStudent().getName());
		
		return dto;
		
		
	}

	@Override
	public FamilyDetails updateFamilyDetails(FamilyDetails familyDetails, long id) {
		
		FamilyDetails currentFamilyDetails = familyDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family", "Id", id));
		
		if(familyDetails.getRelation() != null)
			currentFamilyDetails.setRelation(familyDetails.getRelation());
		
		if(familyDetails.getAge()>0)
			currentFamilyDetails.setAge(familyDetails.getAge());
		
		if(familyDetails.getPhoneNo() > 999999999L && familyDetails.getPhoneNo()<=9999999999L)
			currentFamilyDetails.setPhoneNo(familyDetails.getPhoneNo());
		
		if(familyDetails.getOccupation() != null)
			currentFamilyDetails.setOccupation(familyDetails.getOccupation());
		
		familyDetailsRepository.save(currentFamilyDetails);
				
		return currentFamilyDetails;
	}

	@Override
	public void deleteFamilyDetails(long id) {
		
		familyDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family", "Id", id));
		familyDetailsRepository.deleteById(id);
		
	}

}
