package com.example.amaraa.controller.api;

import com.example.amaraa.model.Category;
import com.example.amaraa.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryControllerApi {
    CategoryService categoryService;

    public CategoryControllerApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/category")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/api/category/{id}")
    public Optional<Category> getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/api/category")
    public Category createCategory(Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/api/category")
    public Category updateCategory(Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/api/category")
    public String deleteCategory(Category category) {
        return categoryService.deleteCategory(category);
    }
}
