package com.azhukov.entities;

import javax.persistence.*;

/**
 * Created by Alex Zhukov on 10.08.2016.
 */

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    private Category category;
    private String name;
    
    @Column(columnDefinition = "Decimal(16,2)")
    private double price;
    
    public Product() {
    }
    
    public Product(Category category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}
