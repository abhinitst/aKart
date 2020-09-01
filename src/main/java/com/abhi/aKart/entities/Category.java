package com.abhi.aKart.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private boolean active;
	private String categoryName;
	private String description;
	private String pictureName;
	@Transient
	private byte[] image;

	@Transient
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Product product;

	public Category() {

	}

	public Category(int productId, boolean active, String categoryName, String description, String pictureName,
			byte[] image) {
		super();
		this.categoryId = categoryId;
		this.active = active;
		this.categoryName = categoryName;
		this.description = description;
		this.pictureName = pictureName;
		this.image = image;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
