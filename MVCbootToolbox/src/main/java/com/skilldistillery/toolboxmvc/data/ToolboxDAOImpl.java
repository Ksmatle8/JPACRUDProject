package com.skilldistillery.toolboxmvc.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.toolbox.entities.TypeWrench;
import com.skilldistillery.toolbox.entities.Wrench;

@Service
@Transactional
public class ToolboxDAOImpl implements ToolboxDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Wrench create (Wrench wrench) {
		 
		em.persist(wrench);
		em.flush();
		return wrench;
	}
	
	@Override
	public Wrench update (Integer id, Wrench wrench) {
		
		Wrench updateWrench =  em.find(Wrench.class, id);
		//TypeWrench typeW = em.find(TypeWrench.class, id);
		
		updateWrench.setId(wrench.getId());
		
		//updateWrench.addTypeWrench(wrench.getTypeWrench().get(0));
		
		updateWrench.setBrand(wrench.getBrand());
		updateWrench.setSize(wrench.getSize());
		updateWrench.setWeightLbs(wrench.getWeightLbs());
		updateWrench.setDrawerNumber(wrench.getDrawerNumber());
		updateWrench.setPrice(wrench.getPrice());
		updateWrench.setPartNumber(wrench.getPartNumber());
		
		return updateWrench;
	}
	
	@Override
	public boolean remove(Integer id) {
		Wrench wrench = em.find(Wrench.class, id);
		try {
		em.remove(wrench);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public Wrench findById(Integer id) {
		return em.find(Wrench.class, id);
	}
	@Override
	public Wrench findByKeword() {
		return null;
		
	}
	
	@Override
	public List<Wrench> findAll(){
		String query = "Select wrench From Wrench wrench";
		List<Wrench> wrenches = em.createQuery(query, Wrench.class).getResultList();
		return wrenches;
	}

	@Override
	public TypeWrench findTypeByName(String type) {
		String query = "Select tw From TypeWrench tw where tw.name = :name";
		TypeWrench foundTypeWrench = em.createQuery(query, TypeWrench.class)
							.setParameter("name", type)
							.getSingleResult();
		return foundTypeWrench;
	}
}























