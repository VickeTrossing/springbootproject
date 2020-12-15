package com.vicketrossing.springbootproject.service;

import com.vicketrossing.springbootproject.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    void deleteById(int theId);

    List<Cart> findAllOrder();

    void deleteAll();

    void save(Cart cart);

    Cart theTotal();


}
