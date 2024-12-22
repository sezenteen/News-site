package com.example.amaraa.service;

import com.example.amaraa.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    public Optional<Category> getCategoryById(Long id);
    List<Category> findByCategoryName(String name);
    public Category createCategory(Category category);
    public Category updateCategory(Category category);
    public String deleteCategory(Category category);

}
