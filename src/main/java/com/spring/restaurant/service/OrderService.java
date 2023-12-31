package com.spring.restaurant.service;

import com.spring.restaurant.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderService;

    @Autowired
    public OrderService(OrderRepository orderService) {
        this.orderService = orderService;
    }
}
