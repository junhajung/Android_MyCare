package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CheckList;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {
	

}
