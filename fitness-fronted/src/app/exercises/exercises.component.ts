import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticleType } from '../article-type';
import { Article } from '../article.model';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-exercises',
  templateUrl: './exercises.component.html',
  styleUrls: ['./exercises.component.css']
})
export class ExercisesComponent implements OnInit {

  categoryList$: Observable<any[]>;
  cardCategory;
  constructor(private articleService: ArticleService) { 
    this.cardCategory = "BICEPS";
  }

  ngOnInit(): void {
    this.categoryList$ = this.articleService.getListOfCategories();
  }
}
