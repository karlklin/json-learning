package com.github.karlklin.yaml;

public class Product {

//        - sku         : BL394D
//    quantity    : 4
//    description : Basketball
//    price       : 450.00

    private String sku;
    private int quantity;
    private String description;
    private double price;

    public Product() {
    }

    public Product(String sku, int quantity, String description, double price) {
        this.sku = sku;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
