package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Member findById(String id);
	
	@Query(value="SELECT * FROM VITAMINMEMBER", nativeQuery=true)
	List<Member> findAll();

	
}
