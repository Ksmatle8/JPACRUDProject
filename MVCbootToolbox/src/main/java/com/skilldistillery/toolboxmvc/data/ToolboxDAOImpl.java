package com.skilldistillery.toolboxmvc.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.toolbox.entities.Wrench;

@Service
@Transactional
public class ToolboxDAOImpl implements ToolboxDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ToolboxPU");
	
	@Override
	public Wrench create (Wrench wrench) {
		EntityManager em = emf.createEntityManager();
		 
		em.persist(wrench);
		em.flush();
		
		return wrench;
	}
	
	@Override
	public Wrench update (int id, Wrench wrench) {
		EntityManager em = emf.createEntityManager();
		
		
		Wrench updateWrench =  em.find(Wrench.class, id);
		
		updateWrench.setDrawerNumber(wrench.getDrawerNumber());
		
		em.close();
		
		return updateWrench;
	}
	
	@Override
	public boolean remove(int id) {
		EntityManager em = emf.createEntityManager();
		Wrench wrench = em.find(Wrench.class, id);
		
		em.remove(wrench);
		//System.out.println(wrench);
		
		em.close();
		
		return false;
	}
}
