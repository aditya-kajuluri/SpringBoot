package com.example.demo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
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
	
	@OneToMany(mappedBy = "student")
	private Set<MarksSheet> marksSheet;
	
	@OneToMany(mappedBy = "familyOfStudent")
	private List<FamilyDetails> familyDetails;

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


	
}
