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
import com.skilldistillery.renovationtracker.services.ProjectService;

@RestController
@RequestMapping("api")
public class ProjectController {

	@Autowired
	private ProjectService projServ;

	@GetMapping("test")
	public String ping() {
		return "pong";
	}

	@GetMapping("projects")
	public List<Project> listProjects() {
		return projServ.allProjects();
	}

	@GetMapping("projects/search/{keyword}")
	public List<Project> findPostByKeyword(@PathVariable String keyword) {
		return projServ.findProjectWithNameLike(keyword);
	}

	@DeleteMapping("projects/{id}")
	void deleteComment(@PathVariable int id) {
		projServ.deleteProjectById(id);
	}

	@PostMapping("projects")
	public Project create(HttpServletResponse res, HttpServletRequest req, @RequestBody Project project) {

		Project newProject = projServ.createProject(project);
		if (newProject != null) {
			res.setStatus(201);
		}
		return newProject;
	}
	
	@PutMapping("projects/{id}")
	public Project updateProject (@RequestBody Project project, @PathVariable int id) {
		return projServ.updateProject(project, id);
	}

}