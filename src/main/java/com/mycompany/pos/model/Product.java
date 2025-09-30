package com.mycompany.pos.model;

public class Product {
    private int id;
    private String name;
    private String barcode;
    private String category;
    private double price;
    private int stock;
    
    // ✅ No-arg constructor
    public Product() { }
    
    
    
    public Product(int id, String name, String barcode, String category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters (optional if needed later)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
