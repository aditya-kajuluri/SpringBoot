package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection =  "Student")
@Getter
@Setter
public class Student {
	
	@Transient
	public static final String 	SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	@NotBlank
	@Size(max=100)
	@Indexed(unique = true)
		private String firstName;
		private String lastName;
	
	@NotBlank
	@Size(max=100)
	@Indexed(unique=true)
		private String emailId;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName,String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}

	
	
}
