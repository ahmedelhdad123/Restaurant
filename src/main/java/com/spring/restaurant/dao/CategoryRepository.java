package com.spring.restaurant.dao;

import com.spring.restaurant.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // localhost:8085/categories
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
