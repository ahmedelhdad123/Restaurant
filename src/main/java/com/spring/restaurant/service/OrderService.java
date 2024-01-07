package com.spring.restaurant.service;

import com.spring.restaurant.dao.OrderRepository;
import com.spring.restaurant.entity.Order;
import com.spring.restaurant.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

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

    public List<Order> findByCategory_Id(int page,int size,int id)
    {
        Pageable pageable= PageRequest.of(page, size);
        Page<Order> orderPage = orderRepository.findByCategory_Id(pageable, id);
        if (orderPage.isEmpty())
        {
            throw new ApiRequestException("No orders found for the given id: " + id);
        }else
        {
            return orderPage.getContent();
        }
    }

    public List<Order> findByOrderName(int page,int size,String name)
    {
        Pageable pageable= PageRequest.of(page, size);
        Page<Order> orderPage=orderRepository.findByOrderNameContaining(pageable,name);
        if (orderPage.isEmpty())
        {
            throw new ApiRequestException("No orders found for the given name: " + name);
        }else
        {
            return orderPage.getContent();
        }
    }
    public Order findOrderById(int id){
        Optional<Order> orderTest=orderRepository.findById(id);
        if (orderTest.isPresent())
        {
            return orderTest.get();
        }else
        {
            throw new ApiRequestException("No orders found for the given id : " + id);
        }
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
/////////////////////////////////////////////////////////////
    //  By java Stream
    public long getOrderSizeByName(String name)
    {
        return orderRepository.findAll().stream()
                .filter(order -> order.getOrderName().toLowerCase().contains(name))
                .count();
    }

    /*   By Query
    public long getOrderSizeByName(String name)
    {
        return orderRepository.getOrderSizeByName(name);
    }
     */
    ////////////////////////////////////////////////

    public long getAllOrderPrice()
    {
        return orderRepository.findAll()
                .stream()
                .mapToLong(order -> order.getPrice())
                .sum();
    }

    public long getOrderPriceById(int id)
    {
        return orderRepository.findById(id).get().getPrice();
    }


}
