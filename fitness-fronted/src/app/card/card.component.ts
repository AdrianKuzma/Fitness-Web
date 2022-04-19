import { FavoriteService } from './../favorite.service';
import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Observable } from 'rxjs';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CardComponent implements OnInit {
  @Input() category;

  contentList;
  constructor(private favoriteService: FavoriteService, private articleService: ArticleService, private _sanitizer: DomSanitizer, private changeDetectorRef: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.articleService.getArticleByCategory(this.category).subscribe(content => {
      this.contentList = content;
      this.changeDetectorRef.detectChanges();
    });
  }
  saveVideoUrl(embed: string) {
    return this._sanitizer.bypassSecurityTrustResourceUrl(embed);
   }
   addToFavorite(id: number) {
    this.favoriteService.addArticleToFavorites(id).subscribe();
  }
}
