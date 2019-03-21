package com.cognizant.training.springrabbitmqapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    //private int quantity;
    private boolean onSale;

    public Item withId(Long id) {
        setId(id);
        return this;
    }

    public Item withName(String name) {
        setName(name);
        return this;
    }

    public Item withPrice(double price) {
        setPrice(price);
        return this;
    }

    public Item withOnSale(boolean onSale) {
        setOnSale(onSale);
        return this;
    }

//    public Item withQuantity(int quantity) {
//        setQuantity(quantity);
//        return this;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", onSale=" + onSale +
                '}';
    }
}
