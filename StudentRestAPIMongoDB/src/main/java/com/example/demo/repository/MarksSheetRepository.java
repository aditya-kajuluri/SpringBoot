package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MarksSheet;

@Repository
public interface MarksSheetRepository extends MongoRepository<MarksSheet, String>{

}
