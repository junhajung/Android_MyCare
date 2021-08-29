package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Vitamin;

public interface VitaminRepository extends JpaRepository<Vitamin, Long>{
	
	@Query(value = "SELECT VITAMINID, NAME FROM VITAMIN" , nativeQuery = true)
	List<String> findIdAndName();
	
	@Query(value = "SELECT * FROM VITAMIN WHERE VITAMINID=?" , nativeQuery = true)
	List<Vitamin> findAllById(int vitaminid);
	
	
	List<Vitamin> findNameByvitaminsearchIgnoreCaseContaining(String name);

}
