package com.vicketrossing.springbootproject.service;

import com.vicketrossing.springbootproject.entity.Order;
import com.vicketrossing.springbootproject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAllOrder() {
        return null;
    }


    //@Override
   // public List<Order> findAllOrder() {


       // return orderRepository.findAll();
    }

