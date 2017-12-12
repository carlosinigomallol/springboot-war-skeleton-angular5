import { Injectable } from '@angular/core';
import { Article } from './article';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ArticleService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) { }

  getArticles():  Promise<Article[]> {
    return this.http.get(this.baseUrl + '/charlie/user/articles/')
      .toPromise()
      .then(response => response.json() as Article[])
      .catch(this.handleError);
  }

  createArticle(articleData: Article): Promise<Article> {
    return this.http.post(this.baseUrl + '/charlie/user/article/', articleData)
      .toPromise().then(response => response.json() as Article)
      .catch(this.handleError);
  }

  updateArticle(articleData: Article): Promise<Article> {
    return this.http.put(this.baseUrl + '/charlie/user/article/', articleData)
      .toPromise()
      .then(response => response.json() as Article)
      .catch(this.handleError);
  }

  deleteArticle(articleId: string): Promise<any> {
    return this.http.delete(this.baseUrl + '/charlie/user/article/' + articleId)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
