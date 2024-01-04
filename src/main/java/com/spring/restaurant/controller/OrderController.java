package com.spring.restaurant.controller;

import com.spring.restaurant.entity.Order;
import com.spring.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("allOrder")  // localhost:8085/api/allOrder?page=0&size=10
    public List<Order> getAllOrder(@RequestParam int page,@RequestParam int size){
        return orderService.getAllOrder(page, size);
    }

    @GetMapping("category")  // localhost:8085/api/category?id=
    public List<Order> findByCategory_Id(@RequestParam int id)
    {
        return orderService.findByCategory_Id(id);
    }

    @GetMapping("orderName")  // localhost:8085/api/orderName?name=
    public List<Order> findByOrderName(@RequestParam String name)
    {
        return orderService.findByOrderName(name);
    }

    @GetMapping("getOrder/{id}")  // localhost:8085/api/orderName/{value}
    public Order findOrderById(@PathVariable int id){
        return orderService.findOrderById(id);
    }
    }
