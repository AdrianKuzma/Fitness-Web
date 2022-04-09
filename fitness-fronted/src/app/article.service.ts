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

  getArticleByCategory(category): Observable<Article[]> {
    return this.httpClient.get<Article[]>(`http://localhost:8080/article/exercises/category?category=${category}`)
    // z backendu ti posle obsah rozdeleny podla kategorií
  }

  getArticleById(id: number): Observable<Article> {
    return this.httpClient.get<Article>(`http://localhost:8080/article/${id}`);
  }

  getListOfCategories(): Observable<any[]> {
    return this.httpClient.get<any[]>("http://localhost:8080/article/exercises/allCategories")
    // z backendu ti posle zoznam kategorií
  }
  

}
