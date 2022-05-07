package com.skilldistillery.renovationtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.renovationtracker.entities.Task;
import com.skilldistillery.renovationtracker.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository repo;

	@Override
	public List<Task> allTasks() {
		return repo.findAll();
	}

	@Override
	public List<Task> findTaskWithNameLike(String keyword) {
		String nameLike = "%" + keyword + "%"; 
		return repo.findByNameLike(nameLike);
	}

	@Override
	public Task createTask(Task task) {
		return repo.saveAndFlush(task);	
	}

	@Override
	public Task updateTask(Task task, int id) {
	task.setId(id);
	
	if(repo.existsById(id)) {
		return repo.save(task); 
	}
		return null;
	}

	@Override
	public void deleteTaskById(int taskId) {
		repo.deleteById(taskId);
		
	} 
	
	
}
