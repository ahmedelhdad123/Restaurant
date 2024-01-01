package com.spring.restaurant.service;

import com.spring.restaurant.dao.OrderRepository;
import com.spring.restaurant.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderService;

    @Autowired
    public OrderService(OrderRepository orderService) {
        this.orderService = orderService;
    }

    public List<Order> getAllOrder(){
        return orderService.findAll();
    }

    public List<Order> findByCategory_Id(int id)
    {
        return orderService.findByCategory_Id(id);
    }

    public List<Order> findByOrderName(String name)
    {
        return orderService.findByOrderNameContaining(name);
    }

}
