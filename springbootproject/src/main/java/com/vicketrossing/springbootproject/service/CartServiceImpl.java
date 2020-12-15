package com.vicketrossing.springbootproject.service;

import com.vicketrossing.springbootproject.entity.Cart;
import com.vicketrossing.springbootproject.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;


    @Override
    public void deleteById(int theId) {
        cartRepository.deleteById(theId);
    }

    @Override
    public List<Cart> findAllOrder() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteAll() {
        cartRepository.deleteAll();
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart theTotal() {
        Cart cart = new Cart();

        double theTotalSum = cart.getPrice()*cart.getQuantity();
        return cart;
    }
}
