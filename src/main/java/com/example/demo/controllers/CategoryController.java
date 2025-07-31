package com.example.demo.controllers;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.services.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping ("/api/categories")
public class CategoryController {

    //private CategoryService categoryService; // violation of Dependency Inversion
    private final ICategoryService categoryService;

    // constructor based DI
    CategoryController (ICategoryService _categoryService) {
        this.categoryService = _categoryService;
    }
    @GetMapping
     public List<CategoryDTO> getAllCategories() throws IOException {

        return this.categoryService.getAllCategories();
     }

     @GetMapping("/count")
    public int getCategoryCount() {
        return 5;
     }
}
