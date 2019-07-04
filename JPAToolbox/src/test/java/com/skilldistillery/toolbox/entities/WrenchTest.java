package com.skilldistillery.toolbox.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class WrenchTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Wrench wrench;

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
		//actor = em.find(Actor.class, 1);
		
		wrench = em.find(Wrench.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		//actor = null;
		wrench = null;
	}

	@Disabled
	@Test
	void test() {
		Wrench w = em.find(Wrench.class, 1);
		assertNotNull(w);
		assertEquals(1, w.getId());
		//fail("Not yet implemented");
	}
}
