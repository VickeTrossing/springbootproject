package com.vicketrossing.springbootproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "price")
    private double price;

    public Order(int id, String product_name, double price) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
    }

    public Order(){}

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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }
}
