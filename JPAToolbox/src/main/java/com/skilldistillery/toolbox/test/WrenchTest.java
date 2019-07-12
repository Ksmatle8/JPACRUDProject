package com.skilldistillery.toolbox.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.toolbox.entities.Wrench;

public class WrenchTest {
	
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ToolboxPU");
private static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		WrenchTest test = new WrenchTest();
		
		Wrench wrench = new Wrench();
		
		wrench.setBrand("Snap-On");
		wrench.setSize("3/4");
		test.create(wrench);
	}
	public Wrench create (Wrench wrench) {
		 em.getTransaction().begin();
		em.persist(wrench);
		em.flush();
		em.getTransaction().commit();
		System.out.println(wrench);
		return wrench;
	}
	
	public Wrench update (Integer id, Wrench wrench) {
		
		Wrench updateWrench =  em.find(Wrench.class, id);
		
		updateWrench.setId(wrench.getId());
		updateWrench.setBrand(wrench.getBrand());
		updateWrench.setSize(wrench.getSize());
		updateWrench.setWeightLbs(wrench.getWeightLbs());
		updateWrench.setDrawerNumber(wrench.getDrawerNumber());
		updateWrench.setPrice(wrench.getPrice());
		updateWrench.setPartNumber(wrench.getPartNumber());
		
		return updateWrench;
	}
	
	public boolean remove(Integer id) {
		Wrench wrench = em.find(Wrench.class, id);
		
		em.remove(wrench);
		//System.out.println(wrench);
		
		return false;
	}
	public Wrench findById(Integer id) {
		return em.find(Wrench.class, id);
	}
	public Wrench findByKeword() {
		return null;
		
	}
	
	public List<Wrench> findAll(){
		String query = "Select wrench From Wrench wrench";
		List<Wrench> wrenches = em.createQuery(query, Wrench.class).getResultList();
		return wrenches;
	}
}


