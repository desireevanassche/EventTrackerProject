package com.skilldistillery.renovationtracker.entities;
/* +------------------+---------------+------+-----+---------+-------+
| Field            | Type          | Null | Key | Default | Extra |
+------------------+---------------+------+-----+---------+-------+
| id               | int(11)       | NO   | PRI | NULL    |       |
| name             | varchar(100)  | YES  |     | NULL    |       |
| priority_level   | int(11)       | YES  |     | NULL    |       |
| description      | text          | YES  |     | NULL    |       |
| date_created     | datetime      | YES  |     | NULL    |       |
| start_date       | datetime      | YES  |     | NULL    |       |
| end_date         | datetime      | YES  |     | NULL    |       |
| image_url        | varchar(2000) | YES  |     | NULL    |       |
| project_id       | int(11)       | NO   | MUL | NULL    |       |
+------------------+---------------+------+-----+---------+-------+*/

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name; 
	
	private String description; 
	
	
	@Column(name="priority_level")
	private int priorityLevel; 
	
	
	@Column(name="start_date")
	@CreationTimestamp
	private LocalDateTime startDate;
	
	@Column(name="end_date")
	@CreationTimestamp
	private LocalDateTime endDate;

	
	@Column(name="date_created")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="project_id")
	private Project project;


	//----- END FIELDS --------------------------------
	
	public Task() {
		super();
	}
	
	


	public Task(int id, String name, String description, int priorityLevel, LocalDateTime startDate,
			LocalDateTime endDate, LocalDateTime createdAt, Project project) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.priorityLevel = priorityLevel;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdAt = createdAt;
		this.project = project;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPriorityLevel() {
		return priorityLevel;
	}


	public void setPriorityLevel(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}



	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	

	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Task [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append(", priorityLevel=").append(priorityLevel).append(", startDate=")
				.append(startDate).append(", endDate=").append(endDate).append(", createdAt=").append(createdAt)
				.append(", project=").append(project).append("]");
		return builder.toString();
	}





	
	
	
}
