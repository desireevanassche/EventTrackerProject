package com.skilldistillery.renovationtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.renovationtracker.entities.Project;
import com.skilldistillery.renovationtracker.entities.Task;
import com.skilldistillery.renovationtracker.services.ProjectService;

@RestController
@RequestMapping("api")
public class ProjectController {

	@Autowired
	private ProjectService projServ;

	@GetMapping("test")
	public String testing () {
		return "pong";
	}

	@GetMapping("projects")
	public List<Project> listProjects() {
		return projServ.allProjects();
	}
	
	@GetMapping("projects/{id}")
	public Project findById(HttpServletResponse res, @PathVariable int id) {
		Project project = projServ.findById(id);
		if (project == null) {
			res.setStatus(404);

		}
		return project;
	}
	
	@GetMapping("project/{projectId}/tasks")
	public List<Task> findTasks(HttpServletResponse res, @PathVariable int projectId ) {
		return projServ.findTasksByProjectId(projectId);
	}
	

	@GetMapping("projects/search/{keyword}")
	public List<Project> findProjectsByKeyword(@PathVariable String keyword, HttpServletResponse res) {
		
		List<Project> projects = projServ.findProjectWithNameLike(keyword);
		
		if (projects == null ) {
			res.setStatus(404);
		}
		return projects; 
	}
	
	

	@DeleteMapping("projects/{id}")
	void deleteComment(@PathVariable int id, HttpServletResponse res) {
		projServ.deleteProjectById(id);
	}
	

	@PostMapping("projects")
	public Project create(HttpServletResponse res, HttpServletRequest req, @RequestBody Project project) {

		Project newProject = projServ.createProject(project);
		if (newProject == null) {
			res.setStatus(404);
		} else {
		res.setStatus(201);
		StringBuffer url = req.getRequestURL();
		url.append("/").append(project.getId()); 
		res.setHeader("Location", url.toString()); 
		}
		return newProject;
	}
	
	
	
	
	@PutMapping("projects/{id}")
	public Project updateProject (@RequestBody Project project, @PathVariable int id, HttpServletResponse res, HttpServletRequest req) {
		Project updated = projServ.updateProject(project, id);
		if (updated == null) {
			res.setStatus(404); 
		} else {
			res.setStatus(201); 
			StringBuffer url = req.getRequestURL();
			url.append("/").append(project.getId()); 
			res.setHeader("Location", url.toString()); 
		} return updated; 
	}

}