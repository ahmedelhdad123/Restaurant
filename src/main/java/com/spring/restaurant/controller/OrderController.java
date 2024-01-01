package com.spring.restaurant.controller;

import com.spring.restaurant.entity.Order;
import com.spring.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("allOrder")  // localhost:8085/api/allOrder
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
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
}
