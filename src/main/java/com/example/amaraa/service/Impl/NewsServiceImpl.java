package com.example.amaraa.service.Impl;

import com.example.amaraa.model.News;
import com.example.amaraa.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NewsServiceImpl implements NewsService {
    @Override
    public List<News> getAllNews() {
        return List.of();
    }

    @Override
    public List<News> findByCategoryId(String categoryId) {
        return List.of();
    }

    @Override
    public Optional<News> getNewsById(Long id) {
        return Optional.empty();
    }

    @Override
    public News createNews(News news) {
        return null;
    }

    @Override
    public News updateNews(News news) {
        return null;
    }

    @Override
    public String deleteNews(Long id) {
        return "";
    }
}
