package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom, Long>{
	
	List<Symptom> findByvitaminsearchIgnoreCaseContaining(String vitaminsearch);
}
