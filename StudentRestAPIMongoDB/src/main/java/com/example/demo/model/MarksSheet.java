package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "markssheet")
@Getter
@Setter
public class MarksSheet {
	
	@Id
	private String id;
	private int semester;
	private int sub1;
	private int sub2;
	private int sub3;
	private int sub4;
	private int sub5;
	private int sub6;
	public MarksSheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarksSheet(String id, int semester, int sub1, int sub2, int sub3, int sub4, int sub5, int sub6) {
		super();
		this.id = id;
		this.semester = semester;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
		this.sub6 = sub6;
	}
	
	
}
