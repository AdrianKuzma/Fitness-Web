import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticleType } from './article-type';
import { Article } from './article.model';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private httpClient: HttpClient) { }

  getArticlesByType(type: ArticleType): Observable<Article[]> {
    return this.httpClient.get<Article[]>(`http://localhost:8080/article?type=${type}`);
  }

}
