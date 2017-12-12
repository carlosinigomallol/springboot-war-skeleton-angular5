package com.charlie.example.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.charlie.example.model.entity.Article;
import com.charlie.example.services.service.IArticleService;
import com.charlie.example.web.properties.MyProperties;

@Controller
@RequestMapping("user")
@CrossOrigin("*") // Importante
public class ArticleController {
	@Autowired
	private IArticleService articleService;

	@Autowired
	private MyProperties mp;

	@GetMapping("article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleById(id);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}

	@GetMapping("articles")
	public ResponseEntity<List<Article>> getAllArticles() {
		System.out.println("***********" + mp.getUrl());
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	@PostMapping("article")
	public ResponseEntity<Article> addArticle(@Valid @RequestBody Article article) {
		articleService.addArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.CREATED);
	}

	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}

	@DeleteMapping("article/{articleId}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("articleId") String articleId) {
		articleService.deleteArticle(Integer.valueOf(articleId));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}