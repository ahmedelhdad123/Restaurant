package com.spring.restaurant.service;

import com.spring.restaurant.dao.OrderRepository;
import com.spring.restaurant.entity.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

//    @Autowired
//    public OrderService(OrderRepository orderService) {
//        this.orderRepository = orderService;
//    }

    public List<Order> getAllOrder(int page,int size){
        Pageable pageable= PageRequest.of(page, size);
        return orderRepository.findAll(pageable).getContent();
    }

    public List<Order> findByCategory_Id(int page,int size,int id)
    {
        Pageable pageable= PageRequest.of(page, size);
        return orderRepository.findByCategory_Id(pageable,id).getContent();
    }

    public List<Order> findByOrderName(int page,int size,String name)
    {
        Pageable pageable= PageRequest.of(page, size);
        return orderRepository.findByOrderNameContaining(pageable,name).getContent();
    }

    public Order findOrderById(int id){
        return orderRepository.findById(id).get();
    }

    public Long getSizeOfAllOrder()
    {
        return  orderRepository.count();
    }

    public long getOrderSizeByCategoryId(int id){
        return orderRepository.findAll().stream()
                .filter(order -> order.getCategory().getId()==id)
                .count();
    }

    /*   By java Stream
    public long getOrderSizeByName(String name)
    {
        return orderRepository.findAll().stream()
                .filter(order -> order.getOrderName().contains(name))
                .count();
    }
     */
    public long getOrderSizeByName(String name)
    {
        return orderRepository.getOrderSizeByName(name);
    }
}
