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
@Table(name = "marks_sheet")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MarksSheet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "semester", nullable = false)
	private int semester;

	@Column(name = "subject_1")
	private int sub1;
	
	@Column(name = "subject_2")
	private int sub2;
	
	@Column(name = "subject_3")
	private int sub3;
	
	@Column(name = "subject_4")
	private int sub4;
	
	@Column(name = "subject_5")
	private int sub5;
	
	@Column(name = "subject_6")
	private int sub6;
	
	@ManyToOne()
	@JoinColumn(name = "student_id")
	private Student student;

	public MarksSheet() {
		super();
	}
	
	
	
	public MarksSheet(long id, int semester, int sub1, int sub2, int sub3, int sub4, int sub5, int sub6,
			Student student) {
		super();
		this.id = id;
		this.semester = semester;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
		this.sub6 = sub6;
		this.student = student;
	}

	
	
}
