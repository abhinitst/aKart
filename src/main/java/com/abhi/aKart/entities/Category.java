package com.abhi.aKart.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Size(min = 3, message = "Name must be atleast 3 character!")
	@NotNull(message = "please fill the category name!")
	private String categoryName;
	private String description;
	private String pictureName;
	@NotNull(message = "Please provide Category status!!!!")
	private Boolean active;
	@Transient
	private byte[] image;

	public int getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getDescription() {
		return description;
	}

	public String getPictureName() {
		return pictureName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] bs) {
		this.image = bs;
	}

}
