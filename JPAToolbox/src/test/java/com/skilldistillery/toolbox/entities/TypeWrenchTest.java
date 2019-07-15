package com.skilldistillery.toolbox.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TypeWrenchTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private TypeWrench type;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("ToolboxPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		
		type = em.find(TypeWrench.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		//actor = null;
		type = null;
	}

	//@Disabled
	@Test
	void test_mapping() {
		TypeWrench tw = em.find(TypeWrench.class, 1);
		assertNotNull(tw);
		assertEquals(1, tw.getId());
		assertEquals("Used for Starters mainly shaped like a half moon", tw.getDescription());
		assertEquals("Moon", tw.getName());
	}
	
	@Test
	void test_TypeWrench_Wrench_ManyToMany() {
		assertNotNull(type.getName());
		System.err.println(type.getWrenchs());
		assertTrue(type.getWrenchs().size()>0);
		assertEquals("10 mm", type.getWrenchs().get(0).getSize());
	}
	
}