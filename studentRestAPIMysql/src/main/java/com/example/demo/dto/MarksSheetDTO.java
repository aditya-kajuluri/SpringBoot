package com.example.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MarksSheetDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private long id;

	
	private int semester;

	private int sub1;
	private int sub2;
	
	private int sub3;
	
	private int sub4;
	
	private int sub5;
	
	private int sub6;
	
	private Long studentId;
	private String studentName;


	
	
}
