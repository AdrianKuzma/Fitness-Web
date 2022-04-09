import { Article } from './../article.model';
import { ArticleService } from './../article.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css']
})
export class ArticleDetailComponent implements OnInit {

  article: Article;

  constructor(
    private route: ActivatedRoute,
    private articleService: ArticleService,
  ) { }

  ngOnInit(): void {
    const id: number = +(this.route.snapshot.paramMap.get('id') ?? 0);

    this.articleService.getArticleById(id)
      .subscribe(article => this.article = article);
  }

}
