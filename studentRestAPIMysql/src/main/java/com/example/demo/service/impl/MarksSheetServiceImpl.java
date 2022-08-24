package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MarksSheetDTO;
import com.example.demo.model.MarksSheet;
import com.example.demo.repository.MarksSheetRepository;
import com.example.demo.service.MarksSheetService;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service("MarksSheetService")
public class MarksSheetServiceImpl implements MarksSheetService{
	
	@Autowired
	private MarksSheetRepository marksSheetRepository;
	
	
	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapperFacade;
	
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
		
//		mapperFactory.classMap(MarksSheet.class, MarksSheetDTO.class);
//		
//		mapperFacade = mapperFactory.getMapperFacade();
//		
//		List<MarksSheetDTO> currentMarksSheetdto = currentMarksSheet.stream().filter(a -> a!=null).<MarksSheetDTO>map(a -> {
//			MarksSheetDTO marksSheet = mapperFacade.map(a, MarksSheetDTO.class);
//			return marksSheet;
//		}).collect(Collectors.toList());
//		
//		return currentMarksSheetdto;
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
	public MarksSheet updatemarksByStudentId(MarksSheet marksSheet, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
