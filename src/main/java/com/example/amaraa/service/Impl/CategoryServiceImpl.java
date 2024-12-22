package com.example.amaraa.service.Impl;

import com.example.amaraa.model.Category;
import com.example.amaraa.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> findByCategoryName(String name) {
        return List.of();
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public String deleteCategory(Category category) {
        return "";
    }
}
