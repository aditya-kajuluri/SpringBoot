package com.example.demo;

import java.util.Date;

public class Student {
	private int studentId ;
	private String studentName;
//	private int grade;
//	private Date dob;
//	private String department;
//	private int classRoom;
	
	public Student(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
