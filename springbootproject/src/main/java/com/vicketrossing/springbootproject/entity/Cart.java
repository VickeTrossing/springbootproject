package com.vicketrossing.springbootproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    private double totalPrice;

    public Cart(int id, String product_name, double price, int quantity) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
    }

    public Cart(){}


    public double getTotalPrice() {
        totalPrice = getPrice()*getQuantity();
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
