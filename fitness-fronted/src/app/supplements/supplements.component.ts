import { Component, OnInit } from '@angular/core';
import { ArticleType } from '../article-type';
import { Article } from '../article.model';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-supplements',
  templateUrl: './supplements.component.html',
  styleUrls: ['./supplements.component.css']
})
export class SupplementsComponent implements OnInit {

  supplements: Article[];
  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleService.getArticlesByType(ArticleType.SUPPLEMENTS).subscribe(supplements => this.supplements = supplements)
  }

}
