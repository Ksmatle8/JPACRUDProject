package com.skilldistillery.toolbox.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Wrench {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String brand;

	private String size;

	@Column(name = "weight_lbs")
	private Double weightLbs;

	@Column(name = "drawer_number")
	private Integer drawerNumber;

	@Column(name = "cost")
	private Double price;

	@Column(name = "part_number")
	private Integer partNumber;

	private String picture;
	
	@ManyToMany
	//(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="wrench_has_wrench_type", 
				joinColumns=@JoinColumn(name="wrench_id"),
				inverseJoinColumns=@JoinColumn(name="wrench_type_id"))
	private List<TypeWrench> typeWrench;
	
	public void addTypeWrench(TypeWrench type) {
		if(typeWrench == null) typeWrench = new ArrayList<>();
		
		if(!typeWrench.contains(type)) {
			typeWrench.add(type);
			type.addWrench(this);
		}
	}

	public void removeTypeWrench(TypeWrench type) {
		if(typeWrench != null && typeWrench.contains(type)) {
			typeWrench.remove(type);
			type.removeWrench(this);
		}
	}
	public List<TypeWrench> getTypeWrench() {
		List<TypeWrench> listCopy = this.typeWrench;
		return listCopy;
	}


	public void setTypeWrench(List<TypeWrench> typeWrench) {
		this.typeWrench = typeWrench;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getWeightLbs() {
		return weightLbs;
	}

	public void setWeightLbs(Double weightLbs) {
		this.weightLbs = weightLbs;
	}

	public Integer getDrawerNumber() {
		return drawerNumber;
	}

	public void setDrawerNumber(Integer drawerNumber) {
		this.drawerNumber = drawerNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(Integer partNumber) {
		this.partNumber = partNumber;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wrench [id=").append(id).append(", brand=").append(brand).append(", size=").append(size)
				.append(", weightLbs=").append(weightLbs).append(", drawerNumber=").append(drawerNumber)
				.append(", price=").append(price).append(", partNumber=").append(partNumber).append(", picture=")
				.append(picture).append(", typeWrench=").append(typeWrench).append("]");
		return builder.toString();
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
		Wrench other = (Wrench) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Wrench() {
		super();
	}

	public Wrench(int id, String brand, String size, Double weightLbs, Integer drawerNumber, Double price,
			Integer partNumber, String picture) {
		super();
		this.id = id;
		this.brand = brand;
		this.size = size;
		this.weightLbs = weightLbs;
		this.drawerNumber = drawerNumber;
		this.price = price;
		this.partNumber = partNumber;
		this.picture = picture;
	}
}
