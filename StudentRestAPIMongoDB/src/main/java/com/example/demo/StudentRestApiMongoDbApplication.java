package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.demo.repository")
@ComponentScan("com.example.demo.*")
public class StudentRestApiMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRestApiMongoDbApplication.class, args);
	}

}
