package com.inventory.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private int prodId;

    private String prodName;
    private int prodQty;
    private double price;

    public Product() {}

    public Product(int prodId, String prodName, int prodQty, double price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodQty = prodQty;
        this.price = price;
    }

    public int getProdId() { return prodId; }
    public void setProdId(int prodId) { this.prodId = prodId; }

    public String getProdName() { return prodName; }
    public void setProdName(String prodName) { this.prodName = prodName; }

    public int getProdQty() { return prodQty; }
    public void setProdQty(int prodQty) { this.prodQty = prodQty; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
