package com.example.amaraa.controller;

import com.example.amaraa.model.Article;
import com.example.amaraa.service.ArticleService;
import com.example.amaraa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    // Display all categories
    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category"; // Thymeleaf template for categories
    }

    // Show Add Article page (part of the category management)
    @GetMapping("/addArticle")
    public String showAddArticlePage(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("article", new Article()); // Bind an empty Article object for the form
        return "addArticle"; // Thymeleaf template for adding articles
    }

    // Handle adding a new article with category
    @PostMapping("/addArticle")
    public String addCategoryArticle(@ModelAttribute Article article) {
        // Logic for saving the article with category
        articleService.saveArticle(article); // Assuming this method will set the category
        return "redirect:/admin/category/categories"; // Redirect to the categories list
    }
}
