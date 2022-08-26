package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "family_details")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class FamilyDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id", nullable = false)
	private long id;

	@Column(name = "relation", nullable = false)
	private String relation;

	@Column(name = "age")
	private int age;
	
	@Column(name = "phoneNo")
	private long phoneNo;
	
	@Column(name = "occupation")
	private String occupation;
	
	@ManyToOne()
	@JoinColumn(name = "student_id")
	private Student familyOfStudent;

	public FamilyDetails() {
		super();
	}

	public FamilyDetails(long id, String relation, int age, long phoneNo, String occupation, Student familyOfStudent) {
		super();
		this.id = id;
		this.relation = relation;
		this.age = age;
		this.phoneNo = phoneNo;
		this.occupation = occupation;
		this.familyOfStudent = familyOfStudent;
	}
	
	
	
}
