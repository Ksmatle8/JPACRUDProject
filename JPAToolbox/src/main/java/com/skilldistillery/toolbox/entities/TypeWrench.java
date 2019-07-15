package com.skilldistillery.toolbox.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wrench_type")
public class TypeWrench {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	@ManyToMany(mappedBy = "typeWrench")
	private List<Wrench> wrenchs;

	public List<Wrench> getWrenchs() {
		return wrenchs;
	}

	public void setWrenchs(List<Wrench> wrench) {
		this.wrenchs = wrench;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeWrench other = (TypeWrench) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TypeWrench [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}

	public TypeWrench(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public TypeWrench() {
		super();
	}

	public void addWrench(Wrench wrench) {
		if (this.wrenchs == null)
			wrenchs = new ArrayList<>();

		if (!wrenchs.contains(wrench)) {
			wrenchs.add(wrench);
			wrench.addTypeWrench(this);
		}
	}

	public void removeWrench(Wrench wrench) {
		if (wrenchs != null && wrenchs.contains(wrench)) {
			wrenchs.remove(wrench);
			wrench.removeTypeWrench(this);
		}
	}

}
