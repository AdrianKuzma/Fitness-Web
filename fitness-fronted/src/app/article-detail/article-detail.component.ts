import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { ArticleService } from './../article.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css']
})
export class ArticleDetailComponent implements OnInit {

  content: SafeHtml;

  constructor(
    private route: ActivatedRoute,
    private articleService: ArticleService,
    private domSanitizer: DomSanitizer,
  ) { }

  ngOnInit(): void {
    const id: number = +(this.route.snapshot.paramMap.get('id') ?? 0);

    this.articleService.getArticleContent(id)
      .subscribe(content => this.content = this.domSanitizer.bypassSecurityTrustHtml(content));
  }

}
