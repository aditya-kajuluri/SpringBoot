package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FamilyDetails;

@Repository
public interface FamilyDetailsRepository extends MongoRepository<FamilyDetails, String>{

}
