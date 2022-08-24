package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MarksSheetDTO;
import com.example.demo.model.MarksSheet;
import com.example.demo.service.MarksSheetService;

@RestController
@RequestMapping("/markssheet")
public class MarksSheetController {
	
	@Autowired
	private MarksSheetService marksSheetService;

//	public MarksSheetController(MarksSheetService marksSheetService) {
//		super();
//		this.marksSheetService = marksSheetService;
//	}
	
	// Create marksSheet REST API
		@PostMapping()
		public ResponseEntity<MarksSheet> saveMarksSheet(@RequestBody MarksSheet marksSheet){
			
			return new ResponseEntity<>(marksSheetService.saveMarksSheet(marksSheet), HttpStatus.CREATED);
		}
		
		// Get all marksSheet REST API
		@GetMapping()
		public List<MarksSheet> getAllMarksSheet(){
			
			return marksSheetService.getAllMarksSheet();
		}
		
		@GetMapping("/student/{studentId}")
		public ResponseEntity < List<MarksSheetDTO>> getMarksByStudentId(@PathVariable("studentId") long studentId){
			
			System.out.println("!!!!check 1");
			return new ResponseEntity<>(marksSheetService.getMarksByStudentId(studentId), HttpStatus.OK);
		}
	
}
