package com.example.amaraa.service;

import com.example.amaraa.model.Article;
import com.example.amaraa.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid article ID: " + id));
    }

    public Article saveArticle(Article article) {
        if (article.getTitle() == null || article.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return articleRepository.save(article);
    }

    public void deleteArticleById(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid article ID: " + id);
        }
        articleRepository.deleteById(id);
    }
}
