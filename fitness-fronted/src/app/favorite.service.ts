import { ArticleType } from './article-type';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Article } from './article.model';

@Injectable({
  providedIn: 'root'
})
export class FavoriteService {

  constructor(private httpClient: HttpClient) { }

  getAllFavoriteArticles(): Observable<Article[]> {
    return this.httpClient.get<Article[]>(`http://localhost:8080/favorites`);
  }

  getFavoriteArticlesByType(type: ArticleType): Observable<Article[]> {
    return this.httpClient.get<Article[]>(`http://localhost:8080/favorites?articleType=${type}`);
  }

  addArticleToFavorites(articleId: number): Observable<Article> {
    return this.httpClient.post<Article>(`http://localhost:8080/favorites/${articleId}`, null);
  }

  removeArticleFromFavorites(articleId: number): Observable<any> {
    return this.httpClient.delete(`http://localhost:8080/favorites/${articleId}`);
  }

}
