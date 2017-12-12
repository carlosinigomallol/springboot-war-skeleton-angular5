package com.charlie.example.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlie.example.model.entity.Article;
import com.charlie.example.services.dao.IArticleDAO;
@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDAO articleDAO;
	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}	
	public List<Article> getAllArticles(){
		return articleDAO.getAllArticles();
	}
	public synchronized Article addArticle(Article article){
       if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
    	   return null;
       } else {
    	   articleDAO.addArticle(article);
    	   return article;
       }
	}
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
