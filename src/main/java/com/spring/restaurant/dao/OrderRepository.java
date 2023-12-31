package com.spring.restaurant.dao;

import com.spring.restaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // localhost:8085/orders
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
