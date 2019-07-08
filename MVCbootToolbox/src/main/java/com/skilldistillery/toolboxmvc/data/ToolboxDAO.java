package com.skilldistillery.toolboxmvc.data;

import com.skilldistillery.toolbox.entities.Wrench;

public interface ToolboxDAO {
	public Wrench create (Wrench wrench);
	public Wrench update (int id, Wrench wrench);
	public boolean remove(int id);
}
