package com.spring.restaurant.service;

import com.spring.restaurant.dao.OrderRepository;
import com.spring.restaurant.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderService) {
        this.orderRepository = orderService;
    }

    public List<Order> getAllOrder(int page,int size){
        Pageable pageable= PageRequest.of(page, size);
        return orderRepository.findAll(pageable).getContent();
    }

    public List<Order> findByCategory_Id(int id)
    {
        return orderRepository.findByCategory_Id(id);
    }

    public List<Order> findByOrderName(String name)
    {
        return orderRepository.findByOrderNameContaining(name);
    }

    public Order findOrderById(int id){
        return orderRepository.findById(id).get();
    }
}
