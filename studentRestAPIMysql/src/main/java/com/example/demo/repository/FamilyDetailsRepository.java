package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.FamilyDetails;

public interface FamilyDetailsRepository extends JpaRepository<FamilyDetails, Long>{
	@Query(value = "SELECT * FROM family_details where student_id =:bvStudentId", nativeQuery = true)
	   public List<FamilyDetails> getFamilyDetailsByStudentId(@Param("bvStudentId") Long studentId);
}
