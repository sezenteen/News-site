package com.example.amaraa.service;

import com.example.amaraa.model.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<News> getAllNews();
    List<News> findByCategoryId(String categoryId);
    Optional<News> getNewsById(Long id);
    News createNews(News news);
    News updateNews(News news);
    String deleteNews(Long id);
}
