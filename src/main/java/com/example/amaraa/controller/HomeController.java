package com.example.amaraa.controller;

import com.example.amaraa.service.CategoryService;
import com.example.amaraa.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final NewsService newsService;

    public HomeController(CategoryService categoryService, NewsService newsService) {
        this.categoryService = categoryService;
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(name = "id", defaultValue = "1") Long id) {
        model.addAttribute("category", categoryService.getAllCategories());
        model.addAttribute("news", newsService.getAllNews());
        return "index";
    }
}
