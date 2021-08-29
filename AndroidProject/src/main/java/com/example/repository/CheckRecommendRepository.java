package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.CheckRecommend;

@Repository
public interface CheckRecommendRepository extends JpaRepository<CheckRecommend, Long>{
	
	List<CheckRecommend> findByCheckedlist(Long checkedlist);
}
