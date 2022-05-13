package com.skilldistillery.renovationtracker.services;

import java.util.List;

import com.skilldistillery.renovationtracker.entities.Project;
import com.skilldistillery.renovationtracker.entities.Task;

public interface ProjectService {

	public List<Project> allProjects(); 
	
	public Project findById(int id); 
	
	public List<Project> findProjectWithNameLike(String keyword);
	
	public List<Project> findProjectByBudgetRange(double min, double max);
	
	public void deleteProjectById(int projectId);
	
	public Project createProject(Project project);
	
	public Project updateProject(Project project, int id); 
	
	public List<Task> findTasksByProjectId(int projectId);
}
