package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.VitaminDay;

public interface VitaminDayRepository  extends JpaRepository<VitaminDay, Long>{


}
