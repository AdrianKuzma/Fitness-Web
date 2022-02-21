import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Input() category;

  contentList;
  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.articleService.getArticleByCategory(this.category).subscribe(content => {
      this.contentList = content;
    });
  }

}
