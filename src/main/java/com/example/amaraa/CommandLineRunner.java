package com.example.amaraa;

import com.example.amaraa.model.Category;
import com.example.amaraa.repository.CategoryRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommandLineRunner {

    private CategoryRepository categoryRepository;

    public void testFindAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        System.out.println(categories); // Check if categories are fetched
    }

}
