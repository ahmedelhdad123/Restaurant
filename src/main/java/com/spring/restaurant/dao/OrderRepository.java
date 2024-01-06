package com.spring.restaurant.dao;

import com.spring.restaurant.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository // localhost:8085/orders
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Page<Order> findByCategory_Id(Pageable pageable, int id);

    Page<Order> findByOrderNameContaining(Pageable pageable ,String name);

    /*    By Query
    @Query("select count (id) from Order where category.id = ?1")
    public long getOrderSizeByCategoryId(int id);
     */

    @Query("select count (id) from Order where orderName like %?1%")
    long getOrderSizeByName(String name);
}
