package com.skilldistillery.renovationtracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {


	private  static EntityManagerFactory emf;
	private EntityManager em;
	private Task task; 
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPARenovationTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	
	
	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		task = em.find(Task.class, 1);
		
	}

	
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		task = null;
	}
	/* 
	mysql> SELECT * FROM task WHERE id = 1;
+----+---------------+----------------+-------------------------------------------------------+---------------------+---------------------+----------+------------+
| id | name          | priority_level | description                                           | date_created        | start_date          | end_date | project_id |
+----+---------------+----------------+-------------------------------------------------------+---------------------+---------------------+----------+------------+
|  1 | Sand Cabinets |              1 | Sand the old stain of cabinets & prep for new stain.  | 2022-04-05 00:00:00 | 2022-07-07 00:00:00 | NULL     |          1 |
+----+---------------+----------------+-------------------------------------------------------+---------------------+---------------------+----------+------------+
	 */

		@Test
		@DisplayName("Test project entity mapping")
		void test() {
			
			assertNotNull(task);
			assertEquals("Sand Cabinets", task.getName());
			assertEquals("Sand the old stain of cabinets & prep for new stain. ", task.getDescription());
			
		}
		@Test
		@DisplayName("Test project to task entity mapping")
		void test2() {
			
			assertNotNull(task);
			assertEquals(1, task.getProject().getId());
		
			
		}
		
		
		
	

}

