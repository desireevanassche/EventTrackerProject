package com.skilldistillery.renovationtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.renovationtracker.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	
	List<Project> findByNameLike(@Param("keyword") String keyword); 
	
	List<Project> findByBudgetBetween(double min, double max);
	
	
	
}
