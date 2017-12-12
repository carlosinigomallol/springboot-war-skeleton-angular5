import { Component,Input,OnInit } from '@angular/core';
import { ArticleService } from './article.service';
import { Article } from './article';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'article-list',
  templateUrl: './article-list.component.html'
})

export class ArticleListComponent implements OnInit {
  	  dateValue = new Date();
  	  minDate = new Date(2000, 0, 1);
  	  maxDate = new Date(2020, 0, 1);
  	  articles: Article[];
	  newArticle: Article = new Article();
	  editing: boolean = false;
	  editingArticle: Article = new Article();
	
	  constructor(
    private articleService: ArticleService,
  ) {}

  ngOnInit(): void {
    this.getArticles();
  }

  getArticles(): void {
    this.articleService.getArticles()
      .then(articles => this.articles = articles );    
  }

  createArticle(articleForm: NgForm): void {
    this.articleService.createArticle(this.newArticle)
      .then(createArticle => {        
        articleForm.reset();
        this.newArticle = new Article();
        this.articles.unshift(createArticle)
      });
  }
  
  toggleCompleted(articleData: Article): void {
    articleData.completed = !articleData.completed;
    this.articleService.updateArticle(articleData)
    .then(updatedArticle => {
      let existingArticle = this.articles.find(article => article.articleId === updatedArticle.articleId);
      Object.assign(existingArticle, updatedArticle);
    });
}

  deleteArticle(articleId: string): void {
    this.articleService.deleteArticle(articleId)
    .then(() => {
      this.articles = this.articles.filter(article => article.articleId != articleId);
    });
  }

  updateArticle(articleData: Article): void {
    console.log(articleData);
    this.articleService.updateArticle(articleData)
    .then(updatedArticle => {
      let existingArticle = this.articles.find(article => article.articleId === updatedArticle.articleId);
      Object.assign(existingArticle, updatedArticle);
      this.clearEditing();
    });
  }

  editArticle(articleData: Article): void {
    this.editing = true;
    Object.assign(this.editingArticle, articleData);
  }

  clearEditing(): void {
    this.editingArticle = new Article();
    this.editing = false;
  }
}