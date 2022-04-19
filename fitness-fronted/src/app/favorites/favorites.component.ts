import { Article } from './../article.model';
import { Observable } from 'rxjs';
import { FavoriteService } from './../favorite.service';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  favorite$: Observable<Article[]>
  constructor(private favoriteService: FavoriteService, private _sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.favorite$ = this.favoriteService.getAllFavoriteArticles();
  }

  saveVideoUrl(embed: string) {
    return this._sanitizer.bypassSecurityTrustResourceUrl(embed);
   }
   removeFromFavorite(id: number) {
     this.favoriteService.removeArticleFromFavorites(id).subscribe(()=> {
      this.favorite$ = this.favoriteService.getAllFavoriteArticles();
     });
   }
}
