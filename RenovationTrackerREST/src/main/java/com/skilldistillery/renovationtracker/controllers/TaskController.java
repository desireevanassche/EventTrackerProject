package com.skilldistillery.renovationtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.renovationtracker.entities.Task;
import com.skilldistillery.renovationtracker.services.TaskService;

@RestController
@RequestMapping("api")
public class TaskController {

	@Autowired
	private TaskService taskServ;
	
	@GetMapping("tasks/test")
	public String ping() {
		return "pong";
	}
	
	@GetMapping("tasks") 
		public List<Task> listTasks() {
		return taskServ.allTasks(); 
	}
	
	@GetMapping("tasks/search/{keyword}")
	public List<Task> findTaskByKeyWord(@PathVariable String keyword) {
	return taskServ.findTaskWithNameLike(keyword);
	}
	
	@PostMapping("tasks")
	public Task create(HttpServletResponse res, HttpServletRequest req, @RequestBody Task task) {
		
		Task newTask = taskServ.createTask(task); 
		if (newTask != null) {
			res.setStatus(201);
		}
		return newTask;
	}
	
	






}
