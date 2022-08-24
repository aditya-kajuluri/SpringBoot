package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "student")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = false)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "grade")
	private int grade;
	
	@Column(name = "dept")
	private String dept;
	
	@Column(name = "class_room")
	private int classRoom;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MarksSheet> marksSheet;

//	without default constructor getting errors or no data -- **research**
public Student() {
	super();
}


public Student(long id, String name, int grade, String dept, int classRoom, Set<MarksSheet> marksSheet) {
	super();
	this.id = id;
	this.name = name;
	this.grade = grade;
	this.dept = dept;
	this.classRoom = classRoom;
	this.marksSheet = marksSheet;
}



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getGrade() {
	return grade;
}

public void setGrade(int grade) {
	this.grade = grade;
}

public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}

public int getClassRoom() {
	return classRoom;
}

public void setClassRoom(int classRoom) {
	this.classRoom = classRoom;
}


public Set<MarksSheet> getMarksSheet() {
	return marksSheet;
}

public void setMarksSheet(Set<MarksSheet> marksSheet) {
	this.marksSheet = marksSheet;
}
	
	
}
