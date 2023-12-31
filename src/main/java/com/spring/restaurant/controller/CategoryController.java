package com.spring.restaurant.controller;

import com.spring.restaurant.entity.Category;
import com.spring.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("allCategory")  // localhost:8085/api/allCategory
    public List<Category> getAllCategory()
    {
        return categoryService.getAllCategory();
    }
}
