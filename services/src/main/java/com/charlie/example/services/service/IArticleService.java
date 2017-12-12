package com.charlie.example.services.service;

import java.util.List;

import com.charlie.example.model.entity.Article;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int articleId);
     Article addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}
