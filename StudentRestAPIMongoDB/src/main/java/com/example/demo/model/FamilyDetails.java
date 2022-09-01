package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "familydetails")
@Getter
@Setter
public class FamilyDetails {
	
	@Id
	private String id;
	private String relation;
	private int age;
	private long phoneNumber;
	private String occupation;
	public FamilyDetails() {
		super();
	}
	public FamilyDetails(String id, String relation, int age, long phoneNumber, String occupation) {
		super();
		this.id = id;
		this.relation = relation;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.occupation = occupation;
	}
	
	
}
