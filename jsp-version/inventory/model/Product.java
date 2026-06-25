package com.inventory.model;

public class Product {
	private int prodId;
	private String prodName;
	private int prodQty;
	private double price;
	
	
	public Product() {
		super();
	}


	public Product(String prodName, int prodQty, double price) {
		super();
		
		this.prodName = prodName;
		this.prodQty = prodQty;
		this.price = price;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public int getProdQty() {
		return prodQty;
	}


	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getProdId() {
		return prodId;
	}


	@Override
	public String toString() {
		return "Product prodId=" + prodId + ", prodName=" + prodName + ", prodQty=" + prodQty + ", price=" + price
				;
	}
	
	
	
	

}
