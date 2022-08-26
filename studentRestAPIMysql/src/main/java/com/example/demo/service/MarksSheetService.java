package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MarksSheetDTO;
import com.example.demo.model.MarksSheet;

public interface MarksSheetService {
	
	MarksSheet saveMarksSheet(MarksSheet marksSheet);
	List<MarksSheet> getAllMarksSheet();
	List<MarksSheetDTO> getMarksByStudentId(long id);
	MarksSheet updateMarksSheet(MarksSheet marksSheet, long id);
	void deleteMarksSheet(long id);
}
