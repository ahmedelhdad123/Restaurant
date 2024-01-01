package com.spring.restaurant.service;

import com.spring.restaurant.dao.CategoryRepository;
import com.spring.restaurant.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@AllArgsConstructor   a other way to inject constructor
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory()
    {
        return categoryRepository.findAll();
    }
}
