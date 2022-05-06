package com.skilldistillery.renovationtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProjectTest {

	private  static EntityManagerFactory emf;
	private EntityManager em;
	private Project project;
	
	
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
		project = em.find(Project.class, 1);
		
	}

	
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		project = null;
	}
/* 
	+----+-----------------+---------------------+---------------------+------------------------------------------------------------------------------------------+---------------------+---------+--------+
	| id | name            | start_date          | end_date            | description                                                                              | created_date        | img_url | budget |
	+----+-----------------+---------------------+---------------------+------------------------------------------------------------------------------------------+---------------------+---------+--------+
	|  1 | Kitchen Remodel | 2022-12-07 00:00:00 | 2022-12-09 00:00:00 | Complete kitchen overhaul with the intention of repurposing as much material as possible | 2022-05-04 00:00:00 |         |   6000 |
		 */
	
		@Test
		@DisplayName("Test project entity mapping")
		void test() {
			
			assertNotNull(project);
			assertEquals("Kitchen Remodel", project.getName());
			assertEquals("Complete kitchen overhaul with the intention of repurposing as much material as possible", project.getDescription());
			assertEquals(6000, project.getBudget());
			
		}
		
		@Test
		@DisplayName("Test project to task entity mapping")
		void test2() {
			
			assertNotNull(project);
				assertTrue(project.getTasks().size() > 0);
			}
			
		}
		
	

