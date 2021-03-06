import { FavoriteService } from './../favorite.service';
import { Article } from './../article.model';
import { ArticleService } from './../article.service';
import { Component, OnInit } from '@angular/core';
import { ArticleType } from '../article-type';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  articles: Article[];

  constructor(private articleService: ArticleService, private favoriteService:FavoriteService) { }

  ngOnInit(): void {
    this.articleService.getArticlesByType(ArticleType.ARTICLES)
      .subscribe(articles => this.articles = articles);
  }
  addToFavorite(id: number) {
    this.favoriteService.addArticleToFavorites(id).subscribe();
  }

}
