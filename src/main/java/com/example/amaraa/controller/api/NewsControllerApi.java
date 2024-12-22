package com.example.amaraa.controller.api;

import com.example.amaraa.model.News;
import com.example.amaraa.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewsControllerApi {
    NewsService newsService;

    public NewsControllerApi(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/api/news")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

//    @GetMapping("/api/category_id/news")
//    public List<News> findByCategoryId(String categoryId) {
//        return newsService.findByCategoryId(categoryId);
//    }

    @GetMapping("/api/news/{id}")
    public Optional<News> getNewsById(Long id) {
        return newsService.getNewsById(id);
    }

    @PostMapping("/api/news")
    public News addNews(@RequestBody News news) {
        return newsService.createNews(news);
    }

    @PutMapping("/api/news")
    public News updateNews(@RequestBody News news) {
        return newsService.updateNews(news);
    }

    @DeleteMapping("/api/news")
    public String deleteNews(Long id) {
        return newsService.deleteNews(id);
    }
}
