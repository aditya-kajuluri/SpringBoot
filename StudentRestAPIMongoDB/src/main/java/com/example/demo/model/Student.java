package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "student")
@Getter
@Setter
public class Student {
	
	@Id
	private String id;
	private String name;
	private int grade;
	private String dept;
	private int classroom;
	
	@DBRef
	private List<MarksSheet> marksSheet;
	
	@DBRef
	private List<FamilyDetails> familyDetails;
	
}
