package com.skilldistillery.renovationtracker.services;

import java.util.List;

import com.skilldistillery.renovationtracker.entities.Project;

public interface ProjectService {

	List<Project> allProjects(); 
	
	List<Project> findProjectWithNameLike(String keyword);
	
	List<Project> findProjectByBudgetRange(double min, double max);
	
	public void deleteProjectById(int projectId);
	
	public Project createProject(Project project);
	
	public Project updateProject(Project project, int id); 
	
}
