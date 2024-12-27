package com.example.amaraa.controller;

import com.example.amaraa.model.Article;
import com.example.amaraa.model.Category;
import com.example.amaraa.service.ArticleService;
import com.example.amaraa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    // Admin dashboard - List all articles
    @GetMapping
    public String adminPanel(Model model) {
        List<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        return "admin";
    }

    // Show Add Article Page
    @GetMapping("/addArticle")
    public String showAddArticlePage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("article", new Article()); // Add an empty article for the form
        return "addArticle";
    }

    // Add Article
    @PostMapping("/admin/addAdminArticle")
    public String addArticle(@ModelAttribute("article") Article article) {
        // Logic here
        return "redirect:/admin";
    }


    // Show Update Article Page
    @GetMapping("/editArticle/{id}")
    public String showEditArticlePage(@PathVariable Long id, Model model) {
        Article article = articleService.getArticleById(id);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("article", article);
        return "editArticle";
    }

    // Update Article
    @PostMapping("/editArticle")
    public String editArticle(@ModelAttribute("article") Article article) {
        articleService.saveArticle(article); // Reuse save method for both add and update
        return "redirect:/admin";
    }

    // Delete Article
    @GetMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return "redirect:/admin";
    }
}
