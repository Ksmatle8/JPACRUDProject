package com.skilldistillery.toolboxmvc.data;

import java.util.List;

import com.skilldistillery.toolbox.entities.Wrench;

public interface ToolboxDAO {
	public Wrench create (Wrench wrench);
	public Wrench update (Integer id, Wrench wrench);
	public boolean remove(Integer id);
	public Wrench findById(Integer id);
	public List<Wrench> findAll();
	public Wrench findByKeword();
}
