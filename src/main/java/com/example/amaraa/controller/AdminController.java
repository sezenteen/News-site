package com.example.amaraa.controller;

import com.example.amaraa.model.Article;
import com.example.amaraa.model.Category;
import com.example.amaraa.service.ArticleService;
import com.example.amaraa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

//    // Admin dashboard - List all articles
//    @GetMapping("/admin")
//    public String adminPanel(Model model) {
//        List<Article> articles = articleService.getAllArticles();
//        model.addAttribute("articles", articles);
//        return "admin";
//    }
    @GetMapping("/articles")
    public String listArticles(Model model) {
        List<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        return "articles/list";
    }

    // Show form to create a new article
    @GetMapping("/create")
    public String createArticleForm(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "articles/create";
    }

    // Save a new article
    @PostMapping("/save")
    public String saveArticle(@ModelAttribute Article article) {
        article.setPublishedAt(LocalDateTime.now());
        articleService.saveArticle(article);
        return "redirect:/articles";
    }

    // Show form to edit an article
    @GetMapping("/edit/{id}")
    public String editArticleForm(@PathVariable Long id, Model model) {
        Article article = articleService.getArticleById(id);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("article", article);
        model.addAttribute("categories", categories);
        return "articles/edit";
    }

    // Update an article
    @PostMapping("/update")
    public String updateArticle(@ModelAttribute Article article) {
        article.setPublishedAt(LocalDateTime.now()); // Update published date
        articleService.saveArticle(article);
        return "redirect:/articles";
    }

    // Delete an article
    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return "redirect:/articles";
    }

}
