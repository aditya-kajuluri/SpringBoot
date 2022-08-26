package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MarksSheetDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MarksSheet;
import com.example.demo.repository.MarksSheetRepository;
import com.example.demo.service.MarksSheetService;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service("MarksSheetService")
public class MarksSheetServiceImpl implements MarksSheetService{
	
	@Autowired
	private MarksSheetRepository marksSheetRepository;
	
	
	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	
//	public MarksSheetServiceImpl(MarksSheetRepository marksSheetRepository) {
//		super();
//		this.marksSheetRepository = marksSheetRepository;
//	}

	@Override
	public MarksSheet saveMarksSheet(MarksSheet marksSheet) {
		return marksSheetRepository.save(marksSheet);
	}

	@Override
	public List<MarksSheet> getAllMarksSheet() {
		return marksSheetRepository.findAll();
	}

	@Override
	public List<MarksSheetDTO> getMarksByStudentId(long studentId) {
		
		List<MarksSheet> currentMarksSheet = marksSheetRepository.getMarksByStudentId(studentId);
		List<MarksSheetDTO> marksSheetsDTO  =  new ArrayList<>();
		currentMarksSheet.stream().forEach(a -> {
			marksSheetsDTO.add(entitytoDTO(a));
		});
		
		return marksSheetsDTO;
	}
	

	private MarksSheetDTO entitytoDTO(MarksSheet currentMarksSheet) {
		
		MarksSheetDTO dto = new MarksSheetDTO(currentMarksSheet.getId(), 
										currentMarksSheet.getSemester(), 
										currentMarksSheet.getSub1(), 
										currentMarksSheet.getSub2(), 
										currentMarksSheet.getSub3(), 
										currentMarksSheet.getSub4(), 
										currentMarksSheet.getSub5(), 
										currentMarksSheet.getSub6(),
										currentMarksSheet.getStudent().getId(),
										currentMarksSheet.getStudent().getName());
		
		return dto;
		
		
	}

	@Override
	public MarksSheet updateMarksSheet(MarksSheet marksSheet, long id) {
		
		// check id exists in DB
		MarksSheet currentMarksSheet = marksSheetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarksSheet", "Id", id));
		
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
		
//		currentMarksSheet.setStudent(marksSheet.getStudent());
		
		marksSheetRepository.save(currentMarksSheet);
		
		return currentMarksSheet;
	}

	@Override
	public void deleteMarksSheet(long id) {
		marksSheetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MarksSheet", "Id", id));
		marksSheetRepository.deleteById(id);
		
	}

}
