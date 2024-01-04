package com.spring.restaurant.dao;

import com.spring.restaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // localhost:8085/orders
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByCategory_Id(int id);

    List<Order> findByOrderNameContaining(String name);

}
