package com.skilldistillery.renovationtracker.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;



/* 
| Field        | Type          | Null | Key | Default | Extra |
+--------------+---------------+------+-----+---------+-------+
| id           | int(11)       | NO   | PRI | NULL    |       |
| name         | varchar(45)   | YES  |     | NULL    |       |
| start_date   | datetime      | YES  |     | NULL    |       |
| end_date     | datetime      | YES  |     | NULL    |       |
| description  | text          | YES  |     | NULL    |       |
| created_date | datetime      | YES  |     | NULL    |       |
| img_url      | varchar(2000) | YES  |     | NULL    |       |
| budget       | double        | YES  |     | NULL    |       |
+--------------+---------------+------+-----+---------+-------+
 * */

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name; 
	
	private String description; 
	
	private double budget; 
	
	@Column(name="img_url")
	private String imageUrl;
	
	@Column(name="start_date")
	@CreationTimestamp
	private LocalDateTime startDate;
	
	@Column(name="end_date")
	@CreationTimestamp
	private LocalDateTime endDate;
	
	@Column(name="created_date")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@JsonIgnore
	@OneToMany(mappedBy="project")
	private List<Task> tasks; 

	
	// --- END FIELDS -----------------------------------------------------
	
	public Project() {
		super();
	}

	
	
	public Project(int id, String name, String description, double budget, String imageUrl, LocalDateTime startDate,
			LocalDateTime endDate, LocalDateTime createdAt, List<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.imageUrl = imageUrl;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdAt = createdAt;
		this.tasks = tasks;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	
	

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project id ").append(id).append("name=").append(name).append(", description=")
				.append(description).append(", budget=").append(budget).append(", imageUrl=").append(imageUrl)
				.append(", startDate=").append(startDate).append(", endDate=").append(endDate).append(", createdAt=")
				.append(createdAt).append(", tasks=").append(tasks).append("]");
		return builder.toString();
	}




	



	
	
	
	 
}
