package com.skilldistillery.renovationtracker.services;

import java.util.List;

import com.skilldistillery.renovationtracker.entities.Task;

public interface TaskService {

	List<Task> allTasks();
	
	List<Task> findProjectTasks(int projectId);
	
	List<Task> findTaskWithNameLike(String keyword);
	
	public Task createTask(int projectId, Task task); 
	
	public Task updateTask(Task task, int taskId, int projectId);
	
	
	public void deleteTaskById(int taskId); 
	
	
}
