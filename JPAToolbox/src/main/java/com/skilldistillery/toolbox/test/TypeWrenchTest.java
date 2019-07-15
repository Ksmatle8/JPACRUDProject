package com.skilldistillery.toolbox.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.toolbox.entities.TypeWrench;
import com.skilldistillery.toolbox.entities.Wrench;

public class TypeWrenchTest {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ToolboxPU");
	private static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		TypeWrenchTest test = new TypeWrenchTest();
		
		TypeWrench type = new TypeWrench();
		
		type.setName("Moon");
		type.setDescription("Ratcheting and Opened End");
		test.create(type);
	}
	public TypeWrench create (TypeWrench type) {
		 em.getTransaction().begin();
		em.persist(type);
		em.flush();
		em.getTransaction().commit();
		System.out.println(type);
		return type;
	}
}
