package com.invoicedemo.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private float price;
	
	public Product() {
		
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}