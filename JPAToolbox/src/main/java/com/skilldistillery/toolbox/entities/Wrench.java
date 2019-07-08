package com.skilldistillery.toolbox.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wrench {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String type;
	
	private String brand;
	
	private Integer size;
	
	@Column(name="weight_lbs")
	private Integer weightLbs;
	
	
	@Column(name="drawer_number")
	private Integer drawerNumber;
	
	private Integer price;
	
	@Column(name="part_number")
	private Integer partNumber;
	
	private String picture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getWeightLbs() {
		return weightLbs;
	}

	public void setWeightLbs(Integer weightLbs) {
		this.weightLbs = weightLbs;
	}

	public Integer getDrawerNumber() {
		return drawerNumber;
	}

	public void setDrawerNumber(Integer drawerNumber) {
		this.drawerNumber = drawerNumber;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
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
		builder.append("Wrench [id=").append(id).append(", type=").append(type).append(", brand=").append(brand)
				.append(", size=").append(size).append(", weightLbs=").append(weightLbs).append(", drawerNumber=")
				.append(drawerNumber).append(", price=").append(price).append(", partNumber=").append(partNumber)
				.append(", picture=").append(picture).append("]");
		return builder.toString();
	}

	
	
	
}
