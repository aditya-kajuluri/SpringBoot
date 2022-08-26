package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.MarksSheet;

public interface MarksSheetRepository extends JpaRepository<MarksSheet, Long>{
	
	@Query(value = "SELECT * FROM marks_sheet where student_Id =:bvStudentId", nativeQuery = true)
	   public List<MarksSheet> getMarksByStudentId(@Param("bvStudentId") Long studentId);
	
	
}
