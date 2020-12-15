package com.vicketrossing.springbootproject.service;


import com.vicketrossing.springbootproject.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<Order> findAllOrder();
}
