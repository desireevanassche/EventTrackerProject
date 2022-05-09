package com.skilldistillery.renovationtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.renovationtracker.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByNameLike(@Param("keyword") String keyword); 
	
	List<Task> findByProject_id(int projectId);
	
	
	
	

}
