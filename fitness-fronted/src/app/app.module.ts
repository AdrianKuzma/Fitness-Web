import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { ExercisesComponent } from './exercises/exercises.component';
import { TrainingComponent } from './training/training.component';
import { SupplementsComponent } from './supplements/supplements.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {MatExpansionModule} from '@angular/material/expansion';
import { CardComponent } from './card/card.component';
import { ArticleComponent } from './article/article.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { FavoritesComponent } from './favorites/favorites.component';
import { AuthInterceptor } from './auth.interceptor';
import { ArticleDetailComponent } from './article-detail/article-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    NavigationBarComponent,
    ExercisesComponent,
    TrainingComponent,
    SupplementsComponent,
    CardComponent,
    ArticleComponent,
    LoginComponent,
    RegisterComponent,
    FavoritesComponent,
    ArticleDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    HttpClientModule,
    MatExpansionModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatExpansionModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
