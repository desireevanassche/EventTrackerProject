package com.skilldistillery.renovationtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.renovationtracker.entities.Project;
import com.skilldistillery.renovationtracker.entities.Task;
import com.skilldistillery.renovationtracker.repositories.ProjectRepository;
import com.skilldistillery.renovationtracker.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repo;

	@Autowired
	private ProjectRepository projRepo;

	@Override
	public List<Task> allTasks() {
		return repo.findAll();
	}

	@Override
	public List<Task> findProjectTasks(int projectId) {
		return repo.findByProject_id(projectId);
	}

	@Override
	public List<Task> findTaskWithNameLike(String keyword) {
		String nameLike = "%" + keyword + "%";
		return repo.findByNameLike(nameLike);
	}

	@Override
	public Task createTask(int projectId, Task task) {
		Optional<Project> op = projRepo.findById(projectId);
		task.setProject(op.get());
		repo.saveAndFlush(task);
		return task;
	}

	@Override
	public void deleteTaskById(int taskId) {
		repo.deleteById(taskId);

	}

	
	@Override
	public Task updateTask(Task task, int taskId, int projectId) {

		Optional<Task> op = repo.findById(taskId);

		if (op.isPresent()) {
			Task managedTask = op.get();

			managedTask.setProject(projRepo.findById(projectId).get());
			managedTask.setId(taskId);
			managedTask.setName(task.getName());
			managedTask.setPriorityLevel(task.getPriorityLevel());
			managedTask.setDescription(task.getDescription());

			return repo.saveAndFlush(managedTask);

		}
		return null;
	}

}
