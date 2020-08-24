package com.abhi.aKart.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private int vendorProductId;
	private String vendorName;
	private String productName;
	@Column(name = "product_description")
	private String productDiscription;
	private String quantity;
	private float unit_price;
	private float msrp;
	@Column(name = "availabe_size")
	private String availableSize;
	@Column(name = "available_color")
	private String color;
	private int discount;
	private float unitWieght;
	public int getProductId() {
		return productId;
	}
	public int getVendorProductId() {
		return vendorProductId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	public String getQuantity() {
		return quantity;
	}
	public float getUnit_price() {
		return unit_price;
	}
	public float getMsrp() {
		return msrp;
	}
	public String getAvailableSize() {
		return availableSize;
	}
	public String getColor() {
		return color;
	}
	public int getDiscount() {
		return discount;
	}
	public float getUnitWieght() {
		return unitWieght;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setVendorProductId(int vendorProductId) {
		this.vendorProductId = vendorProductId;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
	public void setMsrp(float msrp) {
		this.msrp = msrp;
	}
	public void setAvailableSize(String availableSize) {
		this.availableSize = availableSize;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setUnitWieght(float unitWieght) {
		this.unitWieght = unitWieght;
	}
	

}
