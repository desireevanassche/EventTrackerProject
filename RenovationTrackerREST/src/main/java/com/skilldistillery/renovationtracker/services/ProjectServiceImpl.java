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
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository repo;
	
	@Autowired
	private TaskRepository taskRepo;

	@Override
	public List<Project> allProjects() {
		return repo.findAll();
	}

	@Override
	public List<Project> findProjectWithNameLike(String keyword) {
		String nameLike = "%" + keyword + "%";

		return repo.findByNameLike(nameLike);
	}

	@Override
	public List<Project> findProjectByBudgetRange(double min, double max) {
		return repo.findByBudgetBetween(min, max);
	}

	@Override
	public void deleteProjectById(int projectId) {
		repo.deleteById(projectId);
	}

	@Override
	public Project createProject(Project project) {
		return repo.saveAndFlush(project);
	}

	@Override
	public Project updateProject(Project project, int id) {
		project.setId(id);

		if (repo.existsById(id)) {
			return repo.save(project);
		}
		return null;

	}

	@Override
	public Project findById(int id) {
		Optional<Project> op = repo.findById(id);
		Project p = null;

		if (op.isPresent()) {
			p = op.get();
		}
		return p;

	}

	@Override
	public List<Task> findTasksByProjectId(int projectId) {
		return taskRepo.findByProject_id(projectId);
	}

}
