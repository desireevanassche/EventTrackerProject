package com.skilldistillery.renovationtracker.services;

import java.util.List;

import com.skilldistillery.renovationtracker.entities.Task;

public interface TaskService {

	List<Task> allTasks();
	
	List<Task> findTaskWithNameLike(String keyword);
	
	public Task createTask(Task task); 
	
	public Task updateTask(Task task, int id);
	
	public void deleteTaskById(int taskId); 
	
	
}
