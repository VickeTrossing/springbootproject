package com.vicketrossing.springbootproject.service;

import com.vicketrossing.springbootproject.entity.Cart;
import com.vicketrossing.springbootproject.entity.Product;
import com.vicketrossing.springbootproject.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findAll();



    Cart addToCart(int theId);

    Product findById(int theId);

    void save(User theUser);

    double totalPrice();

    void deleteAll();
}
